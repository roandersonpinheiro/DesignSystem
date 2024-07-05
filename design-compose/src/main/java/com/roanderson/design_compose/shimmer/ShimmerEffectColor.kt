package com.roanderson.design_compose.shimmer

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerEffectColor(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition()
    val shimmerTranslateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )

    val gradient = Brush.linearGradient(
        colors = listOf(
            Color.Gray.copy(alpha = 0.6f),
            Color.Gray.copy(alpha = 0.3f),
            Color.Gray.copy(alpha = 0.6f)
        ),
        start = Offset.Zero,
        end = Offset(x = 200f, y = 200f)
    )

    Canvas(modifier = modifier) {
        drawIntoCanvas { canvas ->
            withTransform({
                translate(left = shimmerTranslateAnim.value) {
                    canvas.drawRect(
                        size = Size(this.size.width, this.size.height),
                        brush = gradient
                    )
                }
            }, {})
        }
    }
}

@Composable
fun ShimmerItem() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp, 100.dp)
            .background(
                color = Color.Gray.copy(alpha = 0.2f),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        ShimmerEffect(
            modifier = Modifier
                .matchParentSize()
        )
    }
}

@Composable
fun ShimmerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        repeat(5) {
            ShimmerItem()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}