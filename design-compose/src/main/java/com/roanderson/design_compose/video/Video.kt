@Composable
fun VideoPlayer(
    modifier: Modifier = Modifier,
    videoUri: Uri,
    isMinimized: Boolean = false,
    onMinimizeToggle: () -> Unit
) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(videoUri))
            prepare()
            playWhenReady = true
        }
    }

    DisposableEffect(
        AndroidView(factory = {
            PlayerView(it).apply {
                player = exoPlayer
                useController = !isMinimized
            }
        }, modifier = modifier)
    ) {
        onDispose { exoPlayer.release() }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        IconButton(onClick = onMinimizeToggle) {
            Icon(
                imageVector = if (isMinimized) Icons.Default.Expand else Icons.Default.Minimize,
                contentDescription = null
            )
        }
    }
}
