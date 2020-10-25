package andrey.murzin.com.feature_detail.presentation.view

import andrey.murzin.com.core.base.BaseFragment
import andrey.murzin.com.core.utils.setVisible
import andrey.murzin.com.feature_detail.R
import andrey.murzin.com.feature_detail.di.DetailMeaningComponent
import andrey.murzin.com.feature_detail.presentation.model.DetailMeaningViewModel
import andrey.murzin.com.feature_detail.presentation.presenter.DetailMeaningPresenter
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_info_translate.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class DetailMeaningFragment : BaseFragment(R.layout.fragment_info_translate),
    DetailMeainingView {

    companion object {
        private const val ID_ARG = "ID_ARG"

        fun create(id: Long) = DetailMeaningFragment().apply {
            arguments = Bundle().apply {
                putLong(ID_ARG, id)
            }
        }
    }


    @Inject
    lateinit var provider: Provider<DetailMeaningPresenter>

    @InjectPresenter
    lateinit var presenter: DetailMeaningPresenter

    @ProvidePresenter
    fun provider(): DetailMeaningPresenter = provider.get()

    override fun showLoader(flag: Boolean) {
        progressBar.setVisible(flag)
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    override fun closeScope() {
        super.closeScope()
        DetailMeaningComponent.Initializer.clear()
    }

    override fun showInfo(model: DetailMeaningViewModel) {
        Picasso.get().load(model.imageUrl).into(imgDetailMeaning)
        tvValue.text = model.value
        tvDefenitionLabel.text = model.definition
        tvTranslate.text = model.translate
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DetailMeaningComponent.Initializer.get().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        requireFragmentManager().popBackStack()
    }
}