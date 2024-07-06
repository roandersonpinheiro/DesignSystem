package com.roanderson.design_compose.constraint

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // Create references for the composables to constrain
        val (text1, text2, text3) = createRefs()

        Text(
            text = "Texto 1",
            modifier = Modifier.constrainAs(text1) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(text2.start)
            },
            color = Color.Black
        )

        Text(
            text = "Texto 2",
            modifier = Modifier.constrainAs(text2) {
                top.linkTo(parent.top)
                start.linkTo(text1.end)
                end.linkTo(parent.end)
            },
            color = Color.Black
        )

        Text(
            text = "Texto 3",
            modifier = Modifier.constrainAs(text3) {
                top.linkTo(text1.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            color = Color.Black
        )
    }
}
