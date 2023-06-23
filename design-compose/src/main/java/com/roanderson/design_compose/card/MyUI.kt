package com.roanderson.design_compose.card

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun MyUI() {
    Card {
        Text(
            text = "SemicolonSpace",
            fontSize = 20.sp
        )
    }
}