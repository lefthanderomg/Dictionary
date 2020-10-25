package andrey.murzin.com.translate

import andrey.murzin.com.core.base.ComponentProvider
import andrey.murzin.com.core.provider.AppComponentProvider
import andrey.murzin.com.translate.di.component.AppComponent
import android.app.Application

class App : Application(), ComponentProvider<AppComponentProvider> {

    private val appComponent: AppComponent by lazy {
        AppComponent.Initializer.init(this)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun provideComponent(): AppComponentProvider = appComponent

}