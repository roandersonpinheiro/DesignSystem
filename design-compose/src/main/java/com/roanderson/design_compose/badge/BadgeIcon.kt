package com.roanderson.design_compose.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.model.content.CircleShape

@Composable
fun BadgeIcon(
    icon: ImageVector,
    badgeCount: Int,
    badgeColor: Color = Color.Red,
    badgeTextColor: Color = Color.White,
    badgeShape: Shape = CircleShape,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.size(48.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        if (badgeCount > 0) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(badgeShape)
                    .background(badgeColor)
                    .align(Alignment.TopEnd),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = badgeCount.toString(),
                    color = badgeTextColor,
                    fontSize = 10.sp
                )
            }
        }
    }
}
