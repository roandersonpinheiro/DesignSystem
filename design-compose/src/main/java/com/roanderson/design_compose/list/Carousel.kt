package com.roanderson.design_compose.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class CarouselItem(
    val icon: Int,
    val title: String,
    val content: @Composable () -> Unit
)

@Composable
fun Carousel(
    items: List<CarouselItem>,
    modifier: Modifier = Modifier
) {
    var currentItemIndex by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items.forEachIndexed { index, item ->
                CarouselItem(
                    item = item,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { currentItemIndex = index }
                        .alpha(if (index == currentItemIndex) 1f else 0.5f)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            items[currentItemIndex].content()
        }
    }
}

@Composable
fun CarouselItem(
    item: CarouselItem,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(100.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color.LightGray)
    ) {
        item.icon.let { icon ->
            if (icon != 0) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = item.title,
                    tint = Color.White,
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.Center)
                )
            }
        }

        item.title.let { title ->
            if (!title.isNullOrEmpty()) {
                Text(
                    text = title,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }
}
