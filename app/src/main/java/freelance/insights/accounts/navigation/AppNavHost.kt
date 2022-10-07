package freelance.insights.accounts.navigation

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    modifier: Modifier = Modifier,
    snackBarHostState: SnackbarHostState
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
            AddProjectScreen(snackBarHostState) {
                navHostController.navigateSingleTopTo(Activity.route)
            }
        }

        composable(route = Profile.route) {
            ProfileScreen()
        }

        composable(route = Activity.route) {
            ActivityScreen(snackBarHostState)
        }
    }

}


