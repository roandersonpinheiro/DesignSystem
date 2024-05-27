package com.roanderson.design_compose.animations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomposeanimations.ui.theme.AndroidComposeAnimationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeAnimationsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimatedList()
                }
            }
        }
    }
}

@Composable
fun AnimatedList() {
    val items = List(10) { "Item $it" }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items.forEach { item ->
            AnimatedListItem(item)
        }
    }
}

@Composable
fun AnimatedListItem(item: String) {
    var isExpanded by remember { mutableStateOf(false) }
    
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.LightGray)
            .clickable { isExpanded = !isExpanded }
            .animateContentSize()
            .padding(16.dp)
    ) {
        Column {
            Text(text = item, fontSize = 20.sp)
            AnimatedVisibility(visible = isExpanded) {
                Column {
                    Text(text = "Detail 1", fontSize = 16.sp, color = Color.DarkGray)
                    Text(text = "Detail 2", fontSize = 16.sp, color = Color.DarkGray)
                    Text(text = "Detail 3", fontSize = 16.sp, color = Color.DarkGray)
                }
            }
        }
    }
}
