package com.roanderson.design_compose.divider

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DividerExample(){
    Column {
        Text("Foo")
        Divider(startIndent = 8.dp, thickness = 1.dp, color = Color.Black)
        Text("Bar")
    }
}