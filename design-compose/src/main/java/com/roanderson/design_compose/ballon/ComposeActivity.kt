package com.roanderson.design_compose.ballon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Ballon() {

    val builder = rememberBalloonBuilder {
        setArrowSize(10)
        setWidth(BalloonSizeSpec.WRAP)
        setHeight(BalloonSizeSpec.WRAP)
        setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
        setArrowPosition(0.5f)
        setPadding(12)
        setMarginHorizontal(12)
        setTextSize(15f)
        setCornerRadius(8f)
        setBackgroundColorResource(R.color.skyBlue)
        setBalloonAnimation(BalloonAnimation.ELASTIC)
        setIsVisibleOverlay(true)
        setOverlayColorResource(R.color.overlay)
        setOverlayPaddingResource(R.dimen.editBalloonOverlayPadding)
        setBalloonHighlightAnimation(BalloonHighlightAnimation.SHAKE)
        setOverlayShape(
            BalloonOverlayRoundRect(
                R.dimen.editBalloonOverlayRadius,
                R.dimen.editBalloonOverlayRadius
            )
        )
        setDismissWhenClicked(true)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Balloon(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.Center),
            builder = builder,
            balloonContent = {
                Text(
                    text = "Now you can edit your profile1 profile2 profile3 profile4",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        ) { balloonWindow ->
            Button(
                modifier = Modifier.size(160.dp, 60.dp),
                onClick = { balloonWindow.showAlignTop() }
            ) {
                Text(text = "showAlignTop")
            }
        }

        Balloon(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopStart),
            builder = builder,
            balloonContent = {
                Text(
                    text = "Now you can edit your profile!",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        ) { balloonWindow ->
            Button(
                modifier = Modifier.size(160.dp, 60.dp),
                onClick = { balloonWindow.showAlignTop() }
            ) {
                Text(text = "wrap balloon")
            }
        }

        Balloon(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopEnd),
            builder = builder,
            balloonContent = {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.CenterStart)
                            .background(Color.Blue)
                    )
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                            .background(Color.Blue)
                    )
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .border(2.dp, Color.Red)
                            .align(Alignment.CenterEnd)
                            .background(Color.Blue)
                    )
                }
            }
        ) { balloonWindow ->
            Button(
                modifier = Modifier.size(160.dp, 60.dp),
                onClick = { balloonWindow.showAlignBottom() }
            ) {
                Text(text = "alignments")
            }
        }
    }
}

