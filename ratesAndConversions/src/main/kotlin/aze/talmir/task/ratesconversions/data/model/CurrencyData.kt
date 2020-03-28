package aze.talmir.task.ratesconversions.data.model

import androidx.annotation.DrawableRes

/**
 * A class to hold rate conversion data which
 * to be shown to the user in the UI (layer).
 */
data class CurrencyData(
    val id: Int,
    val code: String,
    val name: String,
    val rate: Double,
    @DrawableRes val flag: Int,
    val isBase: Boolean = false
)
