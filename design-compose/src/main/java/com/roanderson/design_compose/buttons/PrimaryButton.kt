package com.roanderson.design_compose.buttons

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * This is a custom [Button] that provides the shape and styling expected
 * in the Service Order application.
 *
 * @param[text] The text inside the button.
 * @param[onClick] A callback invoked when the user clicks the button.
 * @param[modifier] An optional [Modifier] to configure this component.
 * @param[containerColor] The color of the button in an enabled state.
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    contentColor: Color,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    contentPadding: PaddingValues
) {

    Button(
        onClick = {
            if (isLoading) {
            } else {
                onClick()
            }
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        enabled = enabled,
        contentPadding = contentPadding
    ) {
        if (isLoading) CircularProgressIndicator(
            modifier = Modifier.then(Modifier.size(32.dp)),
            color = Color.White
        ) else Text(text = text)
    }
}
