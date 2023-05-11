package com.roanderson.design_compose.viewpager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun HorizontalPagerBugDemo(
    list: List<String>
) {
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        count = 2,
        state = rememberPagerState(initialPage = 0),
        verticalAlignment = Alignment.CenterVertically
    ) { pageIndex ->
        when (pageIndex) {
            0, 1 -> LazyRow(
                modifier = Modifier,
                contentPadding = PaddingValues(10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                itemsIndexed(list) { index, item ->
                    Text(
                        modifier = Modifier
                            .background(color = if (pageIndex == 0) Color.Green else Color.Red),
                        text = "$item\nPage $pageIndex\nIndex $index",
                        style = androidx.compose.ui.text.TextStyle(textAlign = TextAlign.Center)
                    )
                }
            }
        }
    }
}