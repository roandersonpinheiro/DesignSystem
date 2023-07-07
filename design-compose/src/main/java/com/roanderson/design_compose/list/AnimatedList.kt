package com.roanderson.design_compose.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun AnimatedListItem(name: String, isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Text(text = name, modifier = Modifier.padding(16.dp))
    }
}

@ExperimentalAnimationApi
@Composable
fun MyAnimatedList(names: List<String>) {
    val visibleItems = remember { mutableStateListOf<Boolean>() }
    names.forEachIndexed { index, _ ->
        visibleItems.add(index, true)
    }

    LazyColumn {
        items(names.size) { index ->
            AnimatedListItem(
                name = names[index],
                isVisible = visibleItems[index]
            )
        }
    }
}