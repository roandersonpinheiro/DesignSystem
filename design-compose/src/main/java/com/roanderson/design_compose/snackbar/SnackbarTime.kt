package com.roanderson.design_compose.snackbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun MyApp() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) {
            Button(onClick = {
                coroutineScope.launch {
                    showSnackbarWithTimer(snackbarHostState, "Hello, Snackbar!", 3000)
                }
            }) {
                Text("Show Snackbar")
            }
        }
    }
}

suspend fun showSnackbarWithTimer(snackbarHostState: SnackbarHostState, message: String, durationMillis: Long) {
    snackbarHostState.showSnackbar(message)
    delay(durationMillis)
    snackbarHostState.currentSnackbarData?.dismiss()
}
