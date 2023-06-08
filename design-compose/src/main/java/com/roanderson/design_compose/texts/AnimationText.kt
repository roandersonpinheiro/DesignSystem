package com.roanderson.design_compose.texts

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AnimationText(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var visible by remember { mutableStateOf(false) }

        Button(
            modifier = Modifier.align(Alignment.TopCenter),
            onClick = {
                visible = !visible
            }
        ) {
            Text("Toggle Visibility")
        }

        val animationDuration = 2000

        AnimatedVisibility(
            modifier = Modifier.align(Alignment.BottomCenter),
            visible = visible,
            enter = fadeIn(animationSpec = tween(durationMillis = animationDuration)),
            exit = fadeOut(animationSpec = tween(durationMillis = animationDuration))
        ) {
            Text("ABC")
        }
    }
}
