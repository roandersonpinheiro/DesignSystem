package com.roanderson.design_compose.card

@Composable
fun CardWithDottedBorder() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            width = 2.dp,
            brush = SolidColor(Color.Black),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        ),
        elevation = 4.dp
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Card Content", fontSize = 18.sp)
        }
    }
}
