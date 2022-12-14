package freelance.insights.accounts

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import freelance.insights.accounts.navigation.*
import freelance.insights.accounts.ui.components.BottomNav
import freelance.insights.accounts.ui.theme.AccountantAppTheme
import freelance.insights.accounts.ui.theme.DarkColorPalette

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            AccountantApp()
        }
    }
}

@Composable
fun AccountantApp() {
    AccountantAppTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination

        val snackBarHostState = remember { SnackbarHostState() }
        Scaffold(
            scaffoldState = rememberScaffoldState(snackbarHostState = snackBarHostState),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navController.navigateTo(AddProject.route) },
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_add_24),
                        contentDescription = AddProject.title
                    )
                }
            },
            bottomBar = {
                BottomNav(currentDestination) {
                    navController.navigate(it)
                }
            },
            topBar = { }
        ) { innerPadding ->
            AppNavHost(
                navHostController = navController,
                modifier = Modifier.padding(innerPadding),
                snackBarHostState = snackBarHostState
            )

        }
    }
}