package freelance.insights.accounts.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import freelance.insights.accounts.data.localRepo.AppDatabase
import freelance.insights.accounts.data.localRepo.ProjectFinancialsDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "financials.db"
        ).build()
    }

    @Provides
    fun provideLogDao(database: AppDatabase): ProjectFinancialsDao {
        return database.projectFinancialsDao()
    }
}
