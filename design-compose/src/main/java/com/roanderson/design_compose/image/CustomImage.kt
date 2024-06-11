package com.roanderson.design_compose.image

@Composable
fun CustomImage(
    imageUrl: String,
    description: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    width: Dp = 200.dp,
    height: Dp = 200.dp,
    placeholderColor: Color = Color.Gray,
    contentDescription: String? = null
) {
    val painter = rememberGlidePainter(
        request = imageUrl,
        fadeIn = true,
        previewPlaceholder = android.R.color.darker_gray
    )

    Box(
        modifier = modifier
            .size(width, height)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription ?: description,
            modifier = Modifier.fillMaxSize(),
            contentScale = contentScale
        )
    }
}
