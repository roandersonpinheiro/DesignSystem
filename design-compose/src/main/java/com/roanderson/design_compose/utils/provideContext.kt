package com.roanderson.design_compose.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

@Composable
fun provideContext(): Context {
    return LocalContext.current
}

@Composable
fun provideDensity(): Density {
    return LocalDensity.current
}

@Composable
fun provideDp(value: Float): Dp {
    return with(provideDensity()) {
        value.toDp()
    }
}
