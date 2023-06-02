package com.roanderson.design_compose.gridview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@OptIn(ExperimentalFoundationApi::class)
@Composable
 fun GridView(){
    val numbers = (0..20).toList()

    LazyVerticalGrid(
        cells = GridCells.Fixed(4)
    ) {
        items(numbers.size) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Number")
                Text(text = "  $it",)
            }
        }
    }
 }