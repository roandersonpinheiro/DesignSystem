package com.roanderson.design_compose.utils

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import java.util.Base64

@Composable
fun StringToImageVector(base64String: String, modifier: Modifier = Modifier): ImageVector? {
    // Decode the base64 string to a byte array
    val byteArray = Base64.getDecoder().decode(base64String)
    
    // Decode the byte array to a Bitmap
    val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    
    // Convert the Bitmap to an ImageBitmap
    val imageBitmap: ImageBitmap = bitmap.asImageBitmap()
    
    // Create an ImageVector from the ImageBitmap
    val painter: Painter = rememberVectorPainter(imageBitmap)
    return ImageVector.Builder(
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = bitmap.width.toFloat(),
        viewportHeight = bitmap.height.toFloat()
    ).apply {
        // Draw the ImageBitmap onto the ImageVector
        addPath(pathData = painter)
    }.build()
}

@Composable
fun DisplayImageVector(imageVector: ImageVector?, modifier: Modifier = Modifier) {
    imageVector?.let {
        Image(
            painter = rememberVectorPainter(imageVector),
            contentDescription = null,
            modifier = modifier
        )
    }
}
