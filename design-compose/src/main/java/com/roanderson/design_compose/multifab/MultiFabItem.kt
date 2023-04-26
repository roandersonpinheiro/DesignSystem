@file:Suppress("TooManyFunctions", "LongMethod", "FunctionParameterNaming", "FunctionNaming", "LongParameterList")

package com.roanderson.design_compose.multifab


import androidx.compose.ui.graphics.Color

class MultiFabItem(
    val isExtendedFloatingActionButton: Boolean? = true,
    val icon: Int,
    val label: String,
    val labelColor: Color,
    val onClicked: () -> Unit,
    val iconTint: Color?,
    val background: Color?,
)
