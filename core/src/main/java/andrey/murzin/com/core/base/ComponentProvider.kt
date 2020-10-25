package andrey.murzin.com.core.base

interface ComponentProvider<T> {
    fun provideComponent(): T
}