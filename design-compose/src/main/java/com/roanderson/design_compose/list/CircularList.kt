package com.roanderson.design_compose.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CircularList(
    items: List<String>,
    modifier: Modifier = Modifier,
    isEndless: Boolean = false,
    onItemClick: (String) -> Unit
) {
    val listState = rememberLazyListState(
        if (isEndless) Int.MAX_VALUE / 2 else 0
    )

    LazyColumn(
        state = listState,
        modifier = modifier
    ) {
        items(
            count = if (isEndless) Int.MAX_VALUE else items.size,
            itemContent = {
                val index = it % items.size
                Text(text = items[index])    // item composable
            }
        )
    }
}