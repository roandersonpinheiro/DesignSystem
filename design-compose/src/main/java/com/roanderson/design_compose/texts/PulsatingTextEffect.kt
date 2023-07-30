
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PulsatingTextEffect(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    pulsatingColor: Color = Color.Red,
    pulseDuration: Int = 1000,
) {
    var visible by remember { mutableStateOf(true) }
    val infiniteTransition = rememberInfiniteTransition()

    // Use AnimatedVisibility to toggle the visibility of the text
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideInHorizontally(initialOffsetX = { it }),
        exit = fadeOut() + slideOutHorizontally(targetOffsetX = { it }),
        modifier = modifier
    ) {
        Text(
            text = text,
            style = textStyle,
            color = pulsatingColor,
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape) // Clip the text in a circle shape
        )
    }

    // Launch a coroutine to toggle visibility based on the pulseDuration
    LaunchedEffect(pulseDuration) {
        while (true) {
            visible = true
            delay(pulseDuration.toLong() / 2)
            visible = false
            delay(pulseDuration.toLong() / 2)
        }
    }
}
