package aze.talmir.task.ratesconversions.helpers

import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import aze.talmir.task.ratesconversions.R
import aze.talmir.task.ratesconversions.data.model.CurrencyData
import aze.talmir.task.ratesconversions.data.remotesource.network.RatesConversionsApiModel
import kotlin.reflect.full.memberProperties

/**
 * An extension function that maps network call result type value
 * to the type UI type value to show data to the user.
 */
fun RatesConversionsApiModel.asCurrencyData(coefficient: Double): Sequence<CurrencyData> {
    val currencyData = mutableListOf<CurrencyData>()

    // Give unique id to each list item.
    // This will be used in our recycler view adapter class.
    var itemId = 1
    currencyData.add(
        CurrencyData(
            itemId,
            baseCurrency,
            baseCurrency.currencyName(),
            coefficient,
            baseCurrency.flag(),
            true
        )
    )

    // Instead of getting all property values one-by-one,
    // use reflection and let it do it for us :D
    for (prop in RatesConversionsApiModel.Rates::class.memberProperties) {
        itemId += 1
        prop.run {
            currencyData.add(
                CurrencyData(
                    itemId,
                    name,
                    name.currencyName(),
                    coefficient * (prop.get(rates) as Double),
                    name.flag()
                )
            )
        }
    }

    // Don't show base currency from previous list...
    // filter ext function could also be used instead of distinctBy.
    return currencyData.asSequence().distinctBy { it.code }
}

/**
 * The lazy function has an argument with a default value
 * that controls its synchronization behaviour. If a lazy
 * property is accessed from multiple threads concurrently,
 * synchronization will need to be handled by choosing an
 * appropriate [LazyThreadSafetyMode].
 *
 * The default value [LazyThreadSafetyMode.SYNCHRONIZED]
 * will ensure only a single thread can initialize the
 * property using locks. If we are sure the property will
 * only be accessed by a single thread we can switch to
 * [LazyThreadSafetyMode.NONE] to avoid the overhead of
 * performing the synchronization. There is also the option
 * of using [LazyThreadSafetyMode.PUBLICATION] which allows
 * multiple threads to call the initializer, but only the
 * first returned value being used.
 *
 * Most UI code, such as in an Activity or Fragment, will
 * run on the UI thread and so properties that are only used
 * here can use the [LazyThreadSafetyMode.NONE]. We could
 * even add an extension to avoid specifying this each time.
 */
private val mapOfCountryFlags by lazy(LazyThreadSafetyMode.NONE) {
    mapOf(
        "AUD" to R.drawable.aud,
        "BGN" to R.drawable.bgn,
        "BRL" to R.drawable.brl,
        "CAD" to R.drawable.cad,
        "CHF" to R.drawable.chf,
        "CNY" to R.drawable.cny,
        "CZK" to R.drawable.czk,
        "DKK" to R.drawable.dkk,
        "EUR" to R.drawable.eur,
        "GBP" to R.drawable.gbp,
        "HKD" to R.drawable.hkd,
        "HRK" to R.drawable.hrk,
        "HUF" to R.drawable.huf,
        "IDR" to R.drawable.idr,
        "ILS" to R.drawable.ils,
        "INR" to R.drawable.inr,
        "ISK" to R.drawable.isk,
        "JPY" to R.drawable.jpy,
        "KRW" to R.drawable.krw,
        "MXN" to R.drawable.mxn,
        "MYR" to R.drawable.myr,
        "NOK" to R.drawable.nok,
        "NZD" to R.drawable.nzd,
        "PHP" to R.drawable.php,
        "PLN" to R.drawable.pln,
        "RON" to R.drawable.ron,
        "RUB" to R.drawable.rub,
        "SEK" to R.drawable.sek,
        "SGD" to R.drawable.sgd,
        "THB" to R.drawable.thb,
        "USD" to R.drawable.usd,
        "ZAR" to R.drawable.zar
    )
}

@DrawableRes
private fun String.flag() = mapOfCountryFlags[this] ?: R.drawable.errno

private val mapOfCurrencyNameByCode by lazy(LazyThreadSafetyMode.NONE) {
    mapOf(
        "AUD" to "Australian Dollar",
        "BGN" to "Bulgarian Lev",
        "BRL" to "Brazilian Real",
        "CAD" to "Canadian Dollar",
        "CHF" to "Swiss Franc",
        "CNY" to "Chinese Yuan",
        "CZK" to "Czech Koruna",
        "DKK" to "Danish Krone",
        "EUR" to "Euro",
        "GBP" to "Pound sterling",
        "HKD" to "Hong Kong Dollar",
        "HRK" to "Croatian Kuna",
        "HUF" to "Hungarian Forint",
        "IDR" to "Indonesian Rupiah",
        "ILS" to "Israeli New Shekel",
        "INR" to "Indian Rupee",
        "ISK" to "Icelandic Króna",
        "JPY" to "Japanese Yen",
        "KRW" to "South Korean won",
        "MXN" to "Mexican Peso",
        "MYR" to "Malaysian Ringgit",
        "NOK" to "Norwegian Krone",
        "NZD" to "New Zealand Dollar",
        "PHP" to "Philippine peso",
        "PLN" to "Poland złoty",
        "RON" to "Romanian Leu",
        "RUB" to "Russian Ruble",
        "SEK" to "Swedish Krona",
        "SGD" to "Singapore Dollar",
        "THB" to "Thai Baht",
        "USD" to "United States Dollar",
        "ZAR" to "South African Rand"
    )
}

private fun String.currencyName() = mapOfCurrencyNameByCode[this] ?: "Unknown Currency"

/**
 * An extension function for [RecyclerView] to set inset divider to it.
 */
fun RecyclerView.setDivider(@DrawableRes drawableRes: Int) {
    val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
    val drawable = ContextCompat.getDrawable(context, drawableRes)
    drawable?.let {
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}
