package com.roanderson.design_compose.foundation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.roanderson.design_compose.R

@Composable
fun ImageResourceDemo() {
    val image: Painter = painterResource(id = R.drawable.ic_email)
    Image(painter = image,contentDescription = "")
}
