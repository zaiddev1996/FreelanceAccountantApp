package freelance.insights.accounts.data.localRepo

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import freelance.insights.accounts.data.models.ProjectFinancials

/**
 * Data access object to query the database.
 */
@Dao
interface ProjectFinancialsDao {

    @Query("SELECT * FROM projects ORDER BY id DESC")
    fun getAll(): List<ProjectFinancials>

    @Insert
    fun insertAll(vararg project: ProjectFinancials)

    @Insert
    fun insertSingle(project: ProjectFinancials): Long

    @Query("DELETE FROM projects")
    fun nukeTable()

    @Query("SELECT * FROM projects ORDER BY id DESC")
    fun selectAllLogsCursor(): Cursor

    @Query("SELECT * FROM projects WHERE id = :id")
    fun selectLogById(id: Long): Cursor?
}
