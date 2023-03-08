package com.demo.jetpackcomposecrashcourse.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.demo.jetpackcomposecrashcourse.R
import com.demo.jetpackcomposecrashcourse.ui.screens.HomeScreen
import com.demo.jetpackcomposecrashcourse.ui.screens.MedicationScreen
import com.demo.jetpackcomposecrashcourse.ui.screens.MetricsScreen
import com.demo.jetpackcomposecrashcourse.ui.screens.UserProfileScreen
import com.demo.jetpackcomposecrashcourse.ui.theme.Blue200

@Composable
fun BottomNavigationBar(navController: NavController) {
    val pages = listOf(
        NavigationItem.Home,
        NavigationItem.Meds,
        NavigationItem.Metrics,
        NavigationItem.UserProfile,
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.LightGray
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        pages.forEach { page ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(
                            id = page.icon
                        ),
                        modifier = Modifier.size(30.dp),
                        contentDescription = page.title
                    )
                },
                selectedContentColor = Blue200,
                unselectedContentColor = Color.LightGray,
                alwaysShowLabel = false,
                selected = currentRoute == page.route,
                onClick = {
                    navController.navigate(page.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Meds.route) {
            MedicationScreen()
        }
        composable(NavigationItem.Metrics.route) {
            MetricsScreen()
        }
        composable(NavigationItem.UserProfile.route) {
            UserProfileScreen()
        }
    }
}