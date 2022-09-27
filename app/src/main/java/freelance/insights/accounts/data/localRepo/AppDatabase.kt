package freelance.insights.accounts.data.localRepo

import androidx.room.Database
import androidx.room.RoomDatabase
import freelance.insights.accounts.data.models.ProjectFinancials

/**
 * SQLite Database for storing the logs.
 */
@Database(entities = [ProjectFinancials::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun projectFinancialsDao(): ProjectFinancialsDao
}