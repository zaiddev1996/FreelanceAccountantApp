package freelance.insights.accounts.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import freelance.insights.accounts.data.localRepo.FinancialsDataSource
import freelance.insights.accounts.data.localRepo.FinancialsLocalRepo
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class RemoteDataSource

@Qualifier
annotation class LocalDataSource

@InstallIn(SingletonComponent::class)
@Module
abstract class LoggingDatabaseModule {

    @LocalDataSource
    @Binds
    abstract fun bindLocalRepo(impl: FinancialsLocalRepo): FinancialsDataSource
}

