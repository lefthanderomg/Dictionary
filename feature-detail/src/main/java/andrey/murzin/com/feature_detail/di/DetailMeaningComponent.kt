package andrey.murzin.com.feature_detail.di

import andrey.murzin.com.core.provider.AppComponentProvider
import andrey.murzin.com.core.scope.FlowScope
import andrey.murzin.com.core.utils.ComponentCreator
import andrey.murzin.com.feature_detail.presentation.view.DetailMeaningFragment
import andrey.murzin.com.network_api.di.NetworkApi
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [NetworkApi::class, AppComponentProvider::class],
    modules = [RepositoryModule::class]
)
@FlowScope
interface DetailMeaningComponent {

    fun inject(fragment: DetailMeaningFragment)

    @Component.Factory
    interface Factory {
        fun create(
            dependency: NetworkApi,
            appComponentProvider: AppComponentProvider,
            @BindsInstance id: Long
        ): DetailMeaningComponent
    }

    class Initializer private constructor() {
        companion object {
            private val componentCreator =
                ComponentCreator<DetailMeaningComponent>()

            fun init(
                networkApi: NetworkApi,
                appComponentProvider: AppComponentProvider,
                id: Long
            ): DetailMeaningComponent =
                componentCreator.create {
                    DaggerDetailMeaningComponent.factory()
                        .create(networkApi, appComponentProvider, id)
                }

            fun get() = componentCreator.component!!

            fun clear() {
                componentCreator.clear()
            }
        }
    }
}