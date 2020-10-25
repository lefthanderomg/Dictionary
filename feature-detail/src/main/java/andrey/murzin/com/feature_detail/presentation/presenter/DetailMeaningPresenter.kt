package andrey.murzin.com.feature_detail.presentation.presenter

import andrey.murzin.com.core.delegate.RecourseDelegate
import andrey.murzin.com.feature_detail.R
import andrey.murzin.com.feature_detail.domain.usecase.GetDetailMeaningUseCase
import andrey.murzin.com.feature_detail.presentation.mapper.DetailMeaningMapper
import andrey.murzin.com.feature_detail.presentation.view.DetailMeainingView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class DetailMeaningPresenter @Inject constructor(
    private val id: Long,
    private val getDetailMeaningUseCase: GetDetailMeaningUseCase,
    private val mapper: DetailMeaningMapper,
    private val recourseRepository: RecourseDelegate
) : MvpPresenter<DetailMeainingView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getInfo(id)
    }

    private fun getInfo(id: Long) {
        getDetailMeaningUseCase.execute(id)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .map {
                mapper.toViewModel(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoader(true)
            }
            .doFinally {
                viewState.showLoader(false)
            }
            .subscribe({
                viewState.showInfo(it)
            }, {
                viewState.showError(
                    it.message ?: recourseRepository.getString(
                        R.string.error_message
                    )
                )
            }).also {
                compositeDisposable.add(it)
            }
    }
}