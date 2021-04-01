package jet.pack.compose.masterdetails.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import jet.pack.compose.masterdetails.ui.screens.details.DetailsScreen
import jet.pack.compose.masterdetails.ui.screens.details.DetailsViewModel
import jet.pack.compose.masterdetails.ui.screens.details.DetailsViewModelFactory
import jet.pack.compose.masterdetails.ui.screens.list.ListScreen
import jet.pack.compose.masterdetails.ui.screens.list.ListViewModel
import jet.pack.compose.masterdetails.ui.screens.list.ListViewModelFactory


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
            val factory = ListViewModelFactory()
            val listViewModel = viewModel<ListViewModel>(factory = factory)
            ListScreen(viewModel = listViewModel, showDetails = actions.showDetails)
        }
        composable(
            Routes.Details + "/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.StringType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments!!.getString("itemId")!!
            val factory = DetailsViewModelFactory(itemId = itemId)
            val detailsViewModel = viewModel<DetailsViewModel>(factory = factory)
            DetailsScreen(viewModel = detailsViewModel)
        }
    }
}