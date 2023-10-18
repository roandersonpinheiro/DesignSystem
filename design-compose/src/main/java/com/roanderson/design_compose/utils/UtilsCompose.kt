import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import com.example.uiutils.R

class ComposeUtils {
    companion object {
        @Composable
        fun StyledText(
            text: String,
            color: Color = Color.Black,
            fontSize: Sp = 16.sp,
            fontWeight: FontWeight.Normal
        ) {
            Text(
                text = text,
                color = color,
                fontSize = fontSize,
                fontWeight = fontWeight
            )
        }

      
        @Composable
        fun MarginBox(
            modifier: Modifier = Modifier,
            content: @Composable () -> Unit
        ) {
            Column(
                modifier = modifier.then(Modifier.padding(16.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = content
            )
        }

      
        @Composable
        fun SpacerVertical(height: Int) {
            Spacer(modifier = Modifier.height(height.dp))
        }

    
        @Composable
        fun SpacerHorizontal(width: Int) {
            Spacer(modifier = Modifier.width(width.dp))
        }

    
        @Composable
        fun SurfaceContainer(
            content: @Composable () -> Unit
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                content()
            }
        }
    }
}
