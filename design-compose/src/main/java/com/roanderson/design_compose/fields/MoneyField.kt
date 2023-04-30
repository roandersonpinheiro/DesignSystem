package com.roanderson.design_compose.fields
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.roanderson.design_compose.R
import com.roanderson.design_compose.fields.transformations.ThousandSeparatorTransformation

@Composable
fun MoneyField(
    labelText: String?,
    textColor: Color?,
    valueText: String,
    error: String?,
    iconColor: Color?,
    iconClear: Boolean,
    clearText: () -> Unit,
    modifier: Modifier,
    onTextChanged: (String) -> Unit,
) {

    Column {
        OutlinedTextField(
            label = {
                Text(
                    text = labelText ?: stringResource(R.string.label_money),
                    color = textColor ?: MaterialTheme.colors.primary
                )
            },
            value = valueText,
            onValueChange = { value -> onTextChanged(value) },
            isError = error != null,
            modifier = modifier
                // .padding(horizontal = 20.dp)
                .padding(top = 10.dp),
            singleLine = true,
            visualTransformation = ThousandSeparatorTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_money),
                    contentDescription = "",
                    tint = iconColor ?: MaterialTheme.colors.primary,
                    modifier = Modifier.size(24.dp)
                )
            },
            trailingIcon = {
                Row {
                    if (iconClear) {
                        IconButton(
                            onClick = {
                                clearText()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear"
                            )
                        }
                    }
                }
            }

        )
        error?.let {
            ErrorField(it)
        }
    }
}
