package andrey.murzin.com.feature_search.di

import andrey.murzin.com.feature_search.data.repository.SearchRepositoryImpl
import andrey.murzin.com.feature_search.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindSearchRepository(repo: SearchRepositoryImpl): SearchRepository
}