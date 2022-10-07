package freelance.insights.accounts.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import freelance.insights.accounts.R
import freelance.insights.accounts.navigation.Activity
import freelance.insights.accounts.navigation.Home
import freelance.insights.accounts.navigation.Profile
import freelance.insights.accounts.ui.theme.Purple200

@Composable
fun BottomNav(
    currentDestination: NavDestination?,
    onItemSelect: (route: String) -> Unit
) {
    val items = listOf(
        NavigationItem.BottomNavHome,
        NavigationItem.BottomNavActivity,
        NavigationItem.BottomNavProfile
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onSurface,
        elevation = 20.dp,
        modifier = Modifier.height(70.dp)
    ) {

        items.forEach { item ->
            BottomNavigationItem(
                modifier = Modifier.padding(bottom = 10.dp),
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = item.route == currentDestination?.route,
                onClick = {
                    onItemSelect(item.route)
                }
            )
        }
    }
}

sealed class NavigationItem(
    var route: String,
    var icon: Int,
    var title: String
) {
    object BottomNavHome : NavigationItem(
        route = Home.route,
        icon = R.drawable.ic_baseline_home_24,
        title = Home.title
    )

    object BottomNavActivity : NavigationItem(
        route = Activity.route,
        icon = R.drawable.ic_baseline_home_24,
        title = Activity.title
    )

    object BottomNavProfile : NavigationItem(
        route = Profile.route,
        icon = R.drawable.ic_baseline_home_24,
        title = Profile.title
    )
}