package com.roanderson.design_compose.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityMark2(content: @Composable () -> Unit, visible: Boolean, durationMillis: Int) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(
            animationSpec = keyframes {
                this.durationMillis = durationMillis
            }
        ),
        exit = fadeOut(
            animationSpec = keyframes {
                this.durationMillis = durationMillis
            }
        )
    ){
        content()
    }
}