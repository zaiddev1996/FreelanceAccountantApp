package freelance.insights.accounts.utils

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

fun showDateDialog(
    context: Context,
    onDateChanged: (String) -> Unit
) {
    DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            onDateChanged("$mDayOfMonth/${mMonth + 1}/$mYear")
        }, 2022, 1, 1
    ).show()
}