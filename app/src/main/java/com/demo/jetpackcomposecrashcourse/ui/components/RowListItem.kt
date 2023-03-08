package com.demo.jetpackcomposecrashcourse.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.demo.jetpackcomposecrashcourse.R

@Composable
fun RowList(rows: List<String>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 38.dp, vertical = 29.dp)
    ) {
        items(rows.size) { index ->
            RowItem(rows[index])
            if (index < rows.size - 1) {
                Divider(thickness = 14.dp, color = Color.White)
            }
        }
    }
}

@Composable
fun RowItem(text: String) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .fillMaxWidth()
            .height(height = 81.dp)
            .background(color = colorResource(id = R.color.light_blue)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text)
        IconButton(onClick = { /* Do something */ }) {
            Icon(Icons.Filled.Edit, contentDescription = "Favorite")
        }
    }
}