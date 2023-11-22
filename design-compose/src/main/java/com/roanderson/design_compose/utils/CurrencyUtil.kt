package com.roanderson.design_compose.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*
class CurrencyUtil {
    fun formatForBrazilianCurrency(value: BigDecimal) : String {
        val brazilianFormat = DecimalFormat
                .getCurrencyInstance(Locale("pt", "br"))
        return brazilianFormat.format(value)
    }
}