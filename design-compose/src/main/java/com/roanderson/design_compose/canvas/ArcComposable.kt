package com.roanderson.design_compose.canvas

@Composable
private fun ArcComposable(modifier: Modifier) {
    Box(
        modifier = modifier
            .background(Color.Red)
    ) {
        Canvas(modifier = Modifier
            .size(300.dp)
            .clipToBounds()) {
            drawArc(
                color = Color.LightGray,
                -180f,
                180f,
                useCenter = false,
                size = Size(size.width, size.height * 2),
                style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            modifier = Modifier.align(alignment = Alignment.Center),
            text = "20 Mbps",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}