package andrey.murzin.com.feature_search.presentation.presenter

import andrey.murzin.com.core.delegate.RecourseDelegate
import andrey.murzin.com.feature_search.R
import andrey.murzin.com.feature_search.domain.usecase.SearchMeaningUseCase
import andrey.murzin.com.feature_search.presentation.mapper.MeanViewModelMapper
import andrey.murzin.com.feature_search.presentation.view.SearchWordView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class SearchPresenter @Inject constructor(
    private val searchWordUseCase: SearchMeaningUseCase,
    private val mapper: MeanViewModelMapper,
    private val recourseRepository: RecourseDelegate
) : MvpPresenter<SearchWordView>() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    fun searchWord(searchQuery: String) {
        searchWordUseCase.execute(searchQuery)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .map {
                mapper.toViewModel(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showTranslateList(it)
            }, {
                viewState.showError(
                    it.message ?: recourseRepository.getString(
                        R.string.error_message
                    )
                )
            }).also { disposables.add(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}