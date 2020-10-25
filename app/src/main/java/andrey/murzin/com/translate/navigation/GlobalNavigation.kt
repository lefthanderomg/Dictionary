package andrey.murzin.com.translate.navigation

import andrey.murzin.com.feature_detail.presentation.view.DetailMeaningFragment
import andrey.murzin.com.feature_search.presentation.view.SearchFragment
import andrey.murzin.com.translate.R
import androidx.fragment.app.FragmentManager

class GlobalNavigation constructor(
    private val featureInjector: FeatureInjector,
    private val fm: FragmentManager
) {

    fun navigateSearch() {
        featureInjector.createSearchDependency()
        fm.beginTransaction()
            .replace(R.id.mainContainer, SearchFragment())
            .addToBackStack(SearchFragment::class.java.simpleName)
            .commit()
    }

    fun navigateSearchDetail(id: Long) {
        featureInjector.createDetailDependency(id)
        fm.beginTransaction()
            .replace(R.id.mainContainer, DetailMeaningFragment())
            .addToBackStack(DetailMeaningFragment::class.java.simpleName)
            .commit()
    }
}