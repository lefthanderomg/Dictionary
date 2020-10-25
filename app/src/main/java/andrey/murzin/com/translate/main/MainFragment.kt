package andrey.murzin.com.translate.main

import andrey.murzin.com.core.base.BaseFragment
import andrey.murzin.com.core.navigation.GlobalRouter
import andrey.murzin.com.translate.R
import andrey.murzin.com.translate.navigation.FeatureInjector
import andrey.murzin.com.translate.navigation.GlobalNavigation
import android.os.Bundle

class MainFragment : BaseFragment(R.layout.fragment_main), GlobalRouter {

    private val currentFragment
        get() = childFragmentManager.findFragmentById(R.id.mainContainer) as? BaseFragment

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: activity?.finish()
    }

    private val globalNavigation by lazy {
        GlobalNavigation(FeatureInjector(requireActivity()), childFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: globalNavigation.navigateSearch()
    }

    override fun navigateDetail(id: Long) {
        globalNavigation.navigateSearchDetail(id)
    }
}