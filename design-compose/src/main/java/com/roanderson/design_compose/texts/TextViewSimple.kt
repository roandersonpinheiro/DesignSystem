package com.roanderson.design_compose.texts

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextViewSimple(textStr: String) {
    Text(text = textStr)
}


@Composable
fun BlueText() {
    Text("Hello World", color = Color.Blue)
}

@Composable
fun BigText() {
    Text("Hello World", fontSize = 30.sp)
}

@Composable
fun ItalicText() {
    Text("Hello World", fontStyle = FontStyle.FONT_SLANT_ITALIC)
}


@Composable
fun BoldText() {
    Text("Hello World", fontWeight = FontWeight.Bold)
}


@Composable
fun CenterText() {
    Text(
        "Hello World", textAlign = TextAlign.Center, modifier = Modifier.width(150.dp)
    )
}

@Composable
fun TextShadow() {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Hello world!",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue, offset = offset, blurRadius = 3f
            )
        )
    )
}

@Composable
fun MultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        }
    )
}


@Preview
@Composable
fun LongText() {
    Text("hello ".repeat(50), maxLines = 2)
}

@Composable
fun OverflowedText() {
    Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
}


@OptIn(ExperimentalTextApi::class)
@Composable
fun BrushText() {
    val gradientColors = listOf(Color.Cyan, Color.Blue, Color.Magenta /*...*/)
    Text(
        text = "brush text ".repeat(20),
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            )
        )
    )
}


// Creating a Outline text
@Composable
fun OutLineText() {

        // Create a Paint that has black stroke
        val textPaintStroke = Paint().asFrameworkPaint().apply {
            isAntiAlias = true
            style = android.graphics.Paint.Style.STROKE
            textSize = 100f
            color = android.graphics.Color.CYAN
            strokeWidth = 12f
            strokeMiter = 10f
            strokeJoin = android.graphics.Paint.Join.ROUND
        }

        // Create a Paint that has white fill
        val textPaint = Paint().asFrameworkPaint().apply {
            isAntiAlias = true
            style = android.graphics.Paint.Style.FILL
            textSize = 100f
            color = android.graphics.Color.WHITE
        }

        // Create a canvas, draw the black stroke and
        // override it with the white fill
        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {
                drawIntoCanvas {
                    it.nativeCanvas.drawText(
                        "Hello World",
                        200f,
                        200.dp.toPx(),
                        textPaintStroke
                    )

                    it.nativeCanvas.drawText(
                        "Hello World",
                        200f,
                        200.dp.toPx(),
                        textPaint
                    )
                }
            }
        )
}