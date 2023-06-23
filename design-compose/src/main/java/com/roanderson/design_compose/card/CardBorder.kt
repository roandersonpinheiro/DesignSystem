package com.roanderson.design_compose.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardBorder() {
    Card(
        border = BorderStroke(width = 2.dp, color = Color.Green),
        elevation = 4.dp
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            text = "SemicolonSpace",
            fontSize = 20.sp
        )
    }
}