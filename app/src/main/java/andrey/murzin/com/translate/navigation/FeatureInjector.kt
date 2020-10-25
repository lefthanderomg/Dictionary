package andrey.murzin.com.translate.navigation

import andrey.murzin.com.core.utils.getAppComponent
import andrey.murzin.com.feature_detail.di.DetailMeaningComponent
import andrey.murzin.com.feature_search.di.SearchComponent
import andrey.murzin.com.network_impl.di.NetworkComponent
import android.app.Activity

class FeatureInjector(
    private val activity: Activity
) {

    fun createSearchDependency() {
        SearchComponent.Initializer.init(
            NetworkComponent.Companion.Initializer.init(),
            activity.getAppComponent()
        )
    }

    fun createDetailDependency(id: Long) {
        DetailMeaningComponent.Initializer.init(
            NetworkComponent.Companion.Initializer.init(),
            activity.getAppComponent(),
            id
        )
    }
}