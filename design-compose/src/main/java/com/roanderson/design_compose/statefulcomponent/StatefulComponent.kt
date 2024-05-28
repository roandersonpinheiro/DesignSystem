package com.roanderson.design_compose.statefulcomponent

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable

@Composable
fun <T> StatefulComponent(
    uiState: UiState<T>,
    onSuccess: @Composable (T) -> Unit,
    onError: @Composable (Throwable) -> Unit
) {
    when (uiState) {
        is UiState.Loading -> {
            CircularProgressIndicator()
        }
        is UiState.Success -> {
            onSuccess(uiState.data)
        }
        is UiState.Error -> {
            onError(uiState.exception)
        }
    }
}
