package andrey.murzin.com.network_impl.di

import andrey.murzin.com.core.scope.AppScope
import andrey.murzin.com.core.utils.ComponentCreator
import andrey.murzin.com.network_api.di.NetworkApi
import dagger.Component

@Component(modules = [NetworkModule::class])
@AppScope
interface NetworkComponent : NetworkApi {

    companion object {
        class Initializer private constructor() {
            companion object {
                private val componentCreator = ComponentCreator<NetworkComponent>()

                fun init(): NetworkComponent =
                    componentCreator.create {
                        DaggerNetworkComponent.create()
                    }
            }
        }
    }
}