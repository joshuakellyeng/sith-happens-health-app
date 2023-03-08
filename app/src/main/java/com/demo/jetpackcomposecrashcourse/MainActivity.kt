package com.demo.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.demo.jetpackcomposecrashcourse.datasource.NetworkLayer.apiClient
import com.demo.jetpackcomposecrashcourse.navigation.BottomNavigationBar
import com.demo.jetpackcomposecrashcourse.navigation.Navigation
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
