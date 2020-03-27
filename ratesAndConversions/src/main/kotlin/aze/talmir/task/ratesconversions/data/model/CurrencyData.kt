package aze.talmir.task.ratesconversions.data.model

import androidx.annotation.DrawableRes

data class CurrencyData(
    val id: Int,
    val code: String,
    val name: String,
    val rate: Double,
    @DrawableRes val flag: Int,
    val isBase: Boolean = false
)
