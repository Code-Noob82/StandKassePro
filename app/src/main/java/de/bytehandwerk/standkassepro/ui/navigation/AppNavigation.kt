package de.bytehandwerk.standkassepro.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.bytehandwerk.standkassepro.ui.screens.pos.composables.PosScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "pos") {
        composable("pos") { PosScreen() }
        // composable("admin") { AdminScreen() }
        // composable("stats") { StatsScreen() }
    }
}