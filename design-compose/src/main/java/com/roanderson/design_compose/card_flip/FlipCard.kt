package com.roanderson.design_compose.card_flip

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

@Composable
    fun FlipCard() {
        
        var rotated by remember { mutableStateOf(false) }

        val rotation by animateFloatAsState(
            targetValue = if (rotated) 180f else 0f,
            animationSpec = tween(500)
        )

        val animateFront by animateFloatAsState(
            targetValue = if (!rotated) 1f else 0f,
            animationSpec = tween(500)
        )

        val animateBack by animateFloatAsState(
            targetValue = if (rotated) 1f else 0f,
            animationSpec = tween(500)
        )

        val animateColor by animateColorAsState(
            targetValue = if (rotated) Color.Red else Color.Blue,
            animationSpec = tween(500)
        )

        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                Modifier
                    .fillMaxSize(.5f)
                    .graphicsLayer {
                        rotationY = rotation
                        cameraDistance = 8 * density
                    }
                    .clickable {
                        rotated = !rotated
                    },
                backgroundColor = animateColor
            )
            {
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(text = if (rotated) "Back" else "Front", 
                         modifier = Modifier
                        .graphicsLayer {
                            alpha = if (rotated) animateBack else animateFront
                            rotationY = rotation
                        })
                }

            }
        }
    }
