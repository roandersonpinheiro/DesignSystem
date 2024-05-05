package com.roanderson.design_compose.utils

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.util.Random

fun Modifier.myCustomMargin(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp
): Modifier {
    return this.then(
        Modifier.padding(
            start = start,
            top = top,
            end = end,
            bottom = bottom
        )
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Modifier.autoShowSoftKeyboardOnFocus(padding: Dp = 0.dp): Modifier {
    var isKeyboardVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(keyboardController, isKeyboardVisible) {
        if (isKeyboardVisible) {
            keyboardController?.show()
        } else {
            keyboardController?.hide()
        }
    }

    val onFocusChanged = rememberUpdatedState { focused: Boolean ->
        if (focused) {
            isKeyboardVisible = true
        }
    }

    return this.padding(padding)
}
fun Modifier.roundedCorner(radius: Int = 4): Modifier {
    return this.then(
        Modifier.clip(shape = RoundedCornerShape(radius.dp))
    )
}
fun Context.openUrlInBrowser(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ControlKeyboard() {
    val keyboardController = LocalSoftwareKeyboardController.current
}
@Composable
fun screenWidth(): Dp {
    val resources: Resources = LocalContext.current.resources
    return with(resources.displayMetrics) {
        widthPixels.dp
    }
}

@Composable
fun screenHeight(): Dp {
    val resources: Resources = LocalContext.current.resources
    return with(resources.displayMetrics) {
        heightPixels.dp
    }
}


fun openLinkInBrowser(url: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}
