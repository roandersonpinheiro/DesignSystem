package com.roanderson.design_compose.utils

sealed class Message {
    abstract val text: String

    data class Success(override val text: String) : Message()
    data class Error(override val text: String) : Message()
}