package andrey.murzin.com.translate.di.component

import andrey.murzin.com.core.provider.AppComponentProvider
import andrey.murzin.com.core.scope.AppScope
import andrey.murzin.com.translate.App
import andrey.murzin.com.translate.di.module.ToolsModule
import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [ToolsModule::class]
)
@AppScope
interface AppComponent : AppComponentProvider {

    fun inject(app: App)


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    class Initializer private constructor() {
        companion object {
            fun init(context: Context): AppComponent {

                return DaggerAppComponent
                    .factory()
                    .create(context)
            }
        }
    }
}