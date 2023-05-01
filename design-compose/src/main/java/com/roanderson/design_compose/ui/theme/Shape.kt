package com.roanderson.design_compose.ui.theme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

const val ROUNDED_CORNER = 50
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val InputBoxShape = Shapes(
    medium = RoundedCornerShape(14.dp)
)

val ButtonShape = RoundedCornerShape(ROUNDED_CORNER)
