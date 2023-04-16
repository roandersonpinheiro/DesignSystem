package com.roanderson.design_compose.validations

const val TEXT_ERROR = "Text is invalid."
const val MAX_LENGTH_TEXT = 4

open class TextState : TextFieldState(
    validator = ::isTexValid,
    errorMessage = { textErrorMessage() }
)

private fun isTexValid(password: String): Boolean {
    return password.length >= MAX_LENGTH_TEXT
}

private fun textErrorMessage() = TEXT_ERROR
