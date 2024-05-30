package com.roanderson.design_compose.animations

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedList() {
    var items by remember { mutableStateOf((1..20).map { ListItem(it, "Item $it") }) }

    LazyColumn {
        items(items, key = { it.id }) { item ->
            AnimatedItem(item = item, onRemove = { removedItem ->
                items = items.filter { it.id != removedItem.id }
            })
        }
    }
}

@Composable
fun AnimatedItem(item: ListItem, onRemove: (ListItem) -> Unit) {
    var visible by remember { mutableStateOf(true) }

    AnimatedVisibility(
        visible = visible,
        enter = expandVertically() + fadeIn(),
        exit = shrinkVertically() + fadeOut(),
        initiallyVisible = false
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            elevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = item.name)
                Button(onClick = {
                    visible = false
                    onRemove(item)
                }) {
                    Text("Remove")
                }
            }
        }
    }
}
