@file:Suppress("DEPRECATION")

package com.roanderson.design_compose.video
import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun VideoPlayer(videoUrl: String,context: Context) {

    val player = remember { SimpleExoPlayer.Builder(context).build() }
    val playWhenReady = remember { mutableStateOf(true) }
    val currentWindow = remember { mutableStateOf(0) }
    val playbackPosition = remember { mutableStateOf(0L) }

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            val playerView = PlayerView(context)
            playerView.player = player
            playerView
        },
        update = { view ->
            val mediaItem = MediaItem.fromUri(videoUrl)
            player.setMediaItem(mediaItem)
            player.playWhenReady = playWhenReady.value
            player.seekTo(currentWindow.value, playbackPosition.value)
            player.prepare()
            view.player = player
        }
    )
}