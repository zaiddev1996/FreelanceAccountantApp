package freelance.insights.accounts.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "Projects")
data class ProjectFinancials(
    var name: String = "",
    var clientName: String = "",
    var projectStart: Int? = null,
    var budget: Int? = null,
    var viaPlatform: String = "",
    var outsourcingBudget: Int? = null,
    var tip: Int? = null
) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
