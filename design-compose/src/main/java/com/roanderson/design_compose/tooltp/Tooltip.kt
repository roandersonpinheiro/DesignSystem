
package com.roanderson.design_compose.tooltp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import kotlinx.coroutines.delay

@Composable
fun Tooltip(
    text: String,
    modifier: Modifier = Modifier,
    delayInMillis: Long = 500L
) {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(delayInMillis)
        isVisible = true
    }

    if (isVisible) {
        Popup(alignment = Alignment.TopStart) {
            Surface(
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color.Black, RoundedCornerShape(4.dp)),
                elevation = 4.dp
            ) {
                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
