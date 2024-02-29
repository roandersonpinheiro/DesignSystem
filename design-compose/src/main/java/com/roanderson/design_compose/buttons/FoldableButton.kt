package com.roanderson.design_compose.buttons

import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun FoldableButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = listOf(
        Color.White,
        Color.LightGray,
        Color.Gray,
        Color.DarkGray,
        Color.Black,
    )

    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = modifier,
    ) {
        val size = LocalDensity.current.size
        val radius = min(size.width, size.height) / 2

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawWithContent(
                drawContent = {
                    Text(
                        text = text,
                        style = TextStyle(fontSize = 16.sp),
                        modifier = Modifier.align(Alignment.Center)
                    )
                },
                content = {
                    drawRadialGradient(
                        colors = colors,
                        center = Offset(radius, radius),
                        radius = radius,
                        tileMode = TileMode.Clamp
                    )
                }
            )
        }
    }
}
