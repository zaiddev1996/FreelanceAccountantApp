package freelance.insights.accounts.ui.screens.activity

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import freelance.insights.accounts.ui.components.AccountListRow

@Composable
fun ActivityScreen(
    scaffoldState: SnackbarHostState,
    activityViewModel: ActivityViewModel = hiltViewModel()
) {

    LazyColumn(modifier = Modifier.padding(15.dp)) {
        itemsIndexed(items = activityViewModel.projectList.value) { _: Int, item ->

            AccountListRow(
                modifier = Modifier.clickable {
//                    onAccountClick(account.name)
                },
                color = Color(0xFF04B97F),
                title = item.name,
                subtitle = item.projectStart!!,
                amount = item.budget!!.toFloat(),
                negative = false
            )
        }
    }

}