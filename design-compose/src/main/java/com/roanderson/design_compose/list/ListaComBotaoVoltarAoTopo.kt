package com.roanderson.design_compose.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roanderson.design_compose.R

@Composable
fun ListaComBotaoVoltarAoTopo() {
    val scrollState by rememberScrollState()

    Scaffold(
        floatingActionButton = {
            if (scrollState.value > 0) {
                FloatingActionButton(
                    onClick = { /* Scroll to top */ },
                    backgroundColor = Color.Gray,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Voltar ao topo",
                        tint = Color.White
                    )
                }
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.End,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(50) { index ->
                ItemLista(index)
            }
        }
    }
}

@Composable
fun ItemLista(index: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        backgroundColor = Color.White,
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Ícone do item",
                modifier = Modifier.size(48.dp),
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Item $index",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}
