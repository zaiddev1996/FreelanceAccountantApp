package freelance.insights.accounts.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "Projects")
@Parcelize
data class ProjectFinancials(
    var name: String = "",
    var clientName: String = "",
    var projectStart: String? = null,
    var projectEnd: String? = null,
    var budget: Long? = null,
    var viaPlatform: String = "",
    var outsourcingBudget: Long? = null,
    var tip: Long? = null
): Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
