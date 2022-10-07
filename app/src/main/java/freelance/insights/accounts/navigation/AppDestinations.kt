package freelance.insights.accounts.navigation

interface AppDestination {
    val route: String
    val title: String
}

object Home : AppDestination {
    override val route = "home"
    override val title = "Home"
}

object AddProject : AppDestination {
    override val route = "addProject"
    override val title = "Add Project"
}

object Profile : AppDestination {
    override val route = "profile"
    override val title = "Profile"
}

object Activity : AppDestination {
    override val route = "activity"
    override val title = "activity"
}

//object SingleAccount : AppDestination {
//    // Added for simplicity, this icon will not in fact be used, as SingleAccount isn't
//    // part of the RallyTabRow selection
//    override val icon = Icons.Filled.Money
//    override val route = "single_account"
//    const val accountTypeArg = "account_type"
//    val routeWithArgs = "$route/{$accountTypeArg}"
//    val arguments = listOf(
//        navArgument(accountTypeArg) { type = NavType.StringType }
//    )
//    val deepLinks = listOf(
//        navDeepLink { uriPattern = "rally://$route/{$accountTypeArg}" }
//    )
//}