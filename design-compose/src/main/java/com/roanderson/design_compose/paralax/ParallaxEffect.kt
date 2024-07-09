package com.roanderson.design_compose.paralax

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.max

@Composable
fun ParallaxEffect() {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {

        Image(
            painter = painterResource(id = R.drawable.your_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .offset { IntOffset(x = 0, y = -scrollState.value / 2) } // Parallax effect
        )

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White.copy(alpha = 0.7f))) {

            Spacer(modifier = Modifier.height(300.dp)) // Spacer to push content below the image

            repeat(10) {
                Text(
                    text = "Content item $it",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}
@Composable
fun PreviewParallaxEffect() {
    ParallaxEffect()
}
