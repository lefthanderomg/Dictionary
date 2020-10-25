package andrey.murzin.com.core.provider

import andrey.murzin.com.core.delegate.RecourseDelegate

interface AppComponentProvider {
    fun provideRecourseRepository(): RecourseDelegate
}