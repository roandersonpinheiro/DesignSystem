package com.roanderson.design_compose.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.lang.Math.ceil

@Composable
fun GridComponent(
    items: List<String>,
    columns: Int,
    modifier: Modifier = Modifier,
    content: @Composable (String) -> Unit
) {
    val rows = ceil(items.size.toDouble() / columns).toInt()
    
    LazyColumn(modifier = modifier) {
        itemsIndexed(items) { index, item ->
            if (index % columns == 0) {
                Row(Modifier.fillMaxWidth()) {
                    for (columnIndex in 0 until columns) {
                        val itemIndex = index + columnIndex
                        if (itemIndex < items.size) {
                            Box(
                                Modifier
                                    .weight(1f)
                                    .padding(4.dp)
                            ) {
                                content(items[itemIndex])
                            }
                        } else {
                            Spacer(
                                Modifier
                                    .weight(1f)
                                    .padding(4.dp)
                            )
                        }
                    }
                }
            }
            if (items.size % columns != 0) {
                Row(Modifier.fillMaxWidth()) {
                    val remainingItems = items.size % columns
                    for (columnIndex in 0 until remainingItems) {
                        val index = items.size - remainingItems + columnIndex
                        Box(
                            Modifier
                                .weight(1f)
                                .padding(4.dp)
                        ) {
                            content(items[index])
                        }
                    }
                    Spacer(Modifier.weight(1f))
                }
            }
        }

    }
}
