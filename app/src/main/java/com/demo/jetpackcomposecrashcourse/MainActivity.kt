package com.demo.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Scaffold(
//        topBar = { TopBar() },

        bottomBar = { BottomNavigationBar() },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
//                ADD ISH LATER
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
fun BottomNavigationBar() {
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
                label = { Text(text = page.title) },
                selectedContentColor = Blue200,
                unselectedContentColor = Color.LightGray,
                alwaysShowLabel = false,
                selected = false,
                onClick = {
                    /* Add code later */
                }
            )
        }
    }
}