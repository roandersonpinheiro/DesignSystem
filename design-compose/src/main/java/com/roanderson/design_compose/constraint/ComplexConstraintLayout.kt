package com.roanderson.design_compose.constraint

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ComplexConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (box1, box2, box3, box4, box5) = createRefs()

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .constrainAs(box2) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .constrainAs(box3) {
                    top.linkTo(box2.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(100.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
                .constrainAs(box4) {
                    top.linkTo(box3.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan)
                .constrainAs(box5) {
                    top.linkTo(box3.bottom, margin = 16.dp)
                    end.linkTo(parent.end)
                }
        )
    }
}
