package freelance.insights.accounts.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
//        restoreState = true
    }

fun NavHostController.navigateTo(route: String) =
    this.navigate(route) {
        launchSingleTop = true
    }