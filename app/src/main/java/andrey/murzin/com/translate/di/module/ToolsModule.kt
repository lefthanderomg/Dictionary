package andrey.murzin.com.translate.di.module

import andrey.murzin.com.core.delegate.RecourseDelegate
import andrey.murzin.com.core.delegate.RecourseDelegateImpl
import andrey.murzin.com.core.scope.AppScope
import android.content.Context
import android.content.res.Resources
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ToolsModule {

    @AppScope
    @Binds
    abstract fun provideRecourseDelegate(delegate: RecourseDelegateImpl): RecourseDelegate

    @Module
    companion object {
        @AppScope
        @Provides
        @JvmStatic
        fun provideResources(context: Context): Resources = context.resources
    }
}