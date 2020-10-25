package andrey.murzin.com.feature_search.di

import andrey.murzin.com.core.provider.AppComponentProvider
import andrey.murzin.com.core.scope.FlowScope
import andrey.murzin.com.core.utils.ComponentCreator
import andrey.murzin.com.feature_search.presentation.view.SearchFragment
import andrey.murzin.com.network_api.di.NetworkApi
import dagger.Component

@Component(
    dependencies = [NetworkApi::class, AppComponentProvider::class],
    modules = [RepositoryModule::class]
)
@FlowScope
interface SearchComponent {

    fun inject(fragment: SearchFragment)

    @Component.Factory
    interface Factory {
        fun create(
            dependency: NetworkApi,
            appComponentProvider: AppComponentProvider
        ): SearchComponent
    }

    class Initializer private constructor() {
        companion object {
            private val componentCreator =
                ComponentCreator<SearchComponent>()

            fun init(
                networkApi: NetworkApi,
                appComponentProvider: AppComponentProvider
            ): SearchComponent =
                componentCreator.create {
                    DaggerSearchComponent.factory().create(networkApi, appComponentProvider)
                }

            fun get() = componentCreator.component!!

            fun clear() {
                componentCreator.clear()
            }
        }
    }


}