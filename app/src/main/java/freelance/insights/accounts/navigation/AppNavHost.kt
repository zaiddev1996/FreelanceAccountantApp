package freelance.insights.accounts.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import freelance.insights.accounts.ui.screens.activity.ActivityScreen
import freelance.insights.accounts.ui.screens.add_project.AddProjectScreen
import freelance.insights.accounts.ui.screens.home.HomeScreen
import freelance.insights.accounts.ui.screens.profile.ProfileScreen

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            HomeScreen()
        }

        composable(route = AddProject.route) {
            AddProjectScreen()
        }

        composable(route = Profile.route) {
            ProfileScreen()
        }

        composable(route = Activity.route) {
            ActivityScreen()
        }
    }

}

fun NavHostController.configuredNavigate(route: String) =
    this.navigate(route) {
        popUpTo(
            this@configuredNavigate.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        launchSingleTop = true
    }
