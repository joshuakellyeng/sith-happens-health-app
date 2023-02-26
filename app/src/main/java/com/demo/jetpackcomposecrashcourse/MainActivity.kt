package com.demo.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.demo.jetpackcomposecrashcourse.datasource.NetworkLayer.apiClient
import com.demo.jetpackcomposecrashcourse.ui.theme.Blue200
import com.demo.jetpackcomposecrashcourse.ui.theme.JetpackcomposecrashcourseTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            apiClient.getData()
        }
        setContent {
            JetpackcomposecrashcourseTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = colorResource(R.color.white)
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}


@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Sith Happens Health App", fontSize = 18.sp) },
        backgroundColor = colorResource(R.color.white),
        contentColor = Color.Black
    )
}

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