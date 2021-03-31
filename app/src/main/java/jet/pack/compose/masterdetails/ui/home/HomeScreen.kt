package jet.pack.compose.masterdetails.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import jet.pack.compose.masterdetails.ui.details.DetailsScreen
import jet.pack.compose.masterdetails.ui.list.ListScreen


private object Routes {
    const val List = "list"
    const val Details = "details"
}

private class Actions(navController: NavHostController) {
    val showDetails: (String) -> Unit = { itemId ->
        navController.navigate(Routes.Details + "/$itemId")
    }
}

@Composable
fun HomeScreen(startDestination: String = Routes.List) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(navController, startDestination = startDestination) {
        composable(Routes.List) {
            ListScreen(showDetails = actions.showDetails)
        }
        composable(
            Routes.Details + "/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsScreen(itemId = backStackEntry.arguments!!.getString("itemId")!!)
        }
    }
}