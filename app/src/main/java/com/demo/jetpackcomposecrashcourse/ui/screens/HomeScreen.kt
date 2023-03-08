package com.demo.jetpackcomposecrashcourse.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.jetpackcomposecrashcourse.R
import com.demo.jetpackcomposecrashcourse.ui.components.RowList


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ) {
        Text(
            stringResource(R.string.welcome),
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            textAlign = TextAlign.Right,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 52.dp, start = 15.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.medicine),
            contentDescription = stringResource(R.string.medicine_art),
            modifier = Modifier
                .size(300.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 10.dp)
        )
        Text(
            stringResource(id = R.string.schedule),
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            textAlign = TextAlign.Right,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 15.dp, start = 15.dp)
        )
        RowList(rows = listOf("Joshua", "Jermain", "Kendrick"))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}