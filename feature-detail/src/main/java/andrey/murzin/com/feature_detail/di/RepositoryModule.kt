package andrey.murzin.com.feature_detail.di

import andrey.murzin.com.feature_detail.data.repository.DetailRepositoryImpl
import andrey.murzin.com.feature_detail.domain.repository.DetailRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindDetailRepository(repo: DetailRepositoryImpl): DetailRepository
}