package com.roanderson.design_compose.texts

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.unit.dp
import com.roanderson.design_compose.ui.theme.PrimaryColor

@Composable
fun TextCircle(){
    Text(
        modifier = Modifier
            .padding(16.dp)
            .drawBehind {
                drawCircle(
                    color = PrimaryColor,
                    radius = this.size.maxDimension
                )
            },
        text = "Hello",
    )
}