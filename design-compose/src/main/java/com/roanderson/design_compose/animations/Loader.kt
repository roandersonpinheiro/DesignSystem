package com.roanderson.design_compose.animations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.roanderson.design_compose.R


@Composable
fun Loader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    LottieAnimation(composition)
}