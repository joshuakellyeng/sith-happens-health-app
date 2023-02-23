package com.demo.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import com.demo.jetpackcomposecrashcourse.datasource.NetworkLayer.apiClient
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
        .fillMaxSize()

    ) {

        Text(
            text = "Welcome back $name!",
            color= Color.Blue,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(15.dp,52.dp)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackcomposecrashcourseTheme {
        Greeting("Joshua")
    }
}