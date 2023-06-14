package com.roanderson.design_compose.toolbar

@Composable
fun ToolbarGradient() {
    TopAppBar(
        modifier = Modifier.background(
            Brush.horizontalGradient(
                colors = listOf(
                    Color.Red,
                    Color.Green
                )
            )
        ),
        title = { Text("UI Components") },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}