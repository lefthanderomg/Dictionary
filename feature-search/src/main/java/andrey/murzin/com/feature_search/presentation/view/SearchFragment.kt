package andrey.murzin.com.feature_search.presentation.view

import andrey.murzin.com.core.base.BaseFragment
import andrey.murzin.com.core.navigation.GlobalRouter
import andrey.murzin.com.core.utils.getDrawableCompat
import andrey.murzin.com.core.utils.hideKeyboard
import andrey.murzin.com.core.utils.rxTextChangeListener
import andrey.murzin.com.feature_search.R
import andrey.murzin.com.feature_search.di.SearchComponent
import andrey.murzin.com.feature_search.presentation.adapter.SearchWordAdapter
import andrey.murzin.com.feature_search.presentation.model.MeaningViewModel
import andrey.murzin.com.feature_search.presentation.presenter.SearchPresenter
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_search_translate.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Provider

class SearchFragment : BaseFragment(R.layout.fragment_search_translate), SearchWordView {

    companion object {
        private const val DEBOUNCE_TIME = 500L
        private const val MIN_LENGTH = 1
    }

    @Inject
    lateinit var provider: Provider<SearchPresenter>

    @InjectPresenter
    lateinit var presenter: SearchPresenter

    @ProvidePresenter
    fun provider(): SearchPresenter = provider.get()

    private val compositeDisposable = CompositeDisposable()
    private lateinit var adapter: SearchWordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        SearchComponent.Initializer.get().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun closeScope() {
        super.closeScope()
        SearchComponent.Initializer.clear()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edSearchTranslate.requestFocus()
        adapter = SearchWordAdapter {
            edSearchTranslate.hideKeyboard()
            (parentFragment as GlobalRouter).navigateDetail(it)
        }
        initList()

        with(edSearchTranslate) {
            rxTextChangeListener(savedInstanceState != null)
                .debounce(DEBOUNCE_TIME, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .filter { it.length >= MIN_LENGTH }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    presenter.searchWord(it)
                }, {}).also {
                    compositeDisposable.add(it)
                }

            setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH && text?.length ?: 0 >= MIN_LENGTH) {
                    presenter.searchWord(text.toString())
                    hideKeyboard()
                }
                return@setOnEditorActionListener true
            }
        }
    }

    override fun showTranslateList(list: List<MeaningViewModel>) {
        adapter.submitList(list)
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        requireActivity().finish()
    }

    private fun initList() {
        with(rvTranslate) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@SearchFragment.adapter
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                ).apply {
                    requireContext().getDrawableCompat(R.drawable.bg_divider)
                        ?.let(this::setDrawable)
                }
            )
        }
    }
}