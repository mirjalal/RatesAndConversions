package aze.talmir.task.ratesconversions.helpers

import aze.talmir.task.ratesconversions.R
import aze.talmir.task.ratesconversions.data.model.CurrencyData
import aze.talmir.task.ratesconversions.data.remotesource.network.RatesConversionsApiModel
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test

class ExtensionsKtTest {

    private val fakeApiData = RatesConversionsApiModel(
        "EUR",
        RatesConversionsApiModel.Rates(
            1.8, 1.8, 1.8, 1.8, 1.8, 1.8, 1.8, 1.8,
            1.8, 1.8, 1.8, 1.8, 1.8, 1.8, 1.8, 1.8,
            1.8, 1.8, 1.8, 1.8, 1.8, 1.8, 1.8, 1.8,
            1.8, 1.8, 1.8, 1.8, 1.8, 1.8, 1.8, 1.8
        )
    )
    private val currencyData = listOf(
        CurrencyData(1, "EUR", "Euro", 2.2, R.drawable.eur, true),
        CurrencyData(2, "AUD", "Australian Dollar", 3.9600000000000004, R.drawable.aud, false),
        CurrencyData(3, "BGN", "Bulgarian Lev", 3.9600000000000004, R.drawable.bgn, false),
        CurrencyData(4, "BRL", "Brazilian Real", 3.9600000000000004, R.drawable.brl, false),
        CurrencyData(5, "CAD", "Canadian Dollar", 3.9600000000000004, R.drawable.cad, false),
        CurrencyData(6, "CHF", "Swiss Franc", 3.9600000000000004, R.drawable.chf, false),
        CurrencyData(7, "CNY", "Chinese Yuan", 3.9600000000000004, R.drawable.cny, false),
        CurrencyData(8, "CZK", "Czech Koruna", 3.9600000000000004, R.drawable.czk, false),
        CurrencyData(9, "DKK", "Danish Krone", 3.9600000000000004, R.drawable.dkk, false),
        CurrencyData(10, "EUR", "Euro", 3.9600000000000004, R.drawable.eur, false),
        CurrencyData(11, "GBP", "Pound sterling", 3.9600000000000004, R.drawable.gbp, false),
        CurrencyData(12, "HKD", "Hong Kong Dollar", 3.9600000000000004, R.drawable.hkd, false),
        CurrencyData(13, "HRK", "Croatian Kuna", 3.9600000000000004, R.drawable.hrk, false),
        CurrencyData(14, "HUF", "Hungarian Forint", 3.9600000000000004, R.drawable.huf, false),
        CurrencyData(15, "IDR", "Indonesian Rupiah", 3.9600000000000004, R.drawable.idr, false),
        CurrencyData(16, "ILS", "Israeli New Shekel", 3.9600000000000004, R.drawable.ils, false),
        CurrencyData(17, "INR", "Indian Rupee", 3.9600000000000004, R.drawable.inr, false),
        CurrencyData(18, "ISK", "Icelandic Króna", 3.9600000000000004, R.drawable.isk, false),
        CurrencyData(19, "JPY", "Japanese Yen", 3.9600000000000004, R.drawable.jpy, false),
        CurrencyData(20, "KRW", "South Korean won", 3.9600000000000004, R.drawable.krw, false),
        CurrencyData(21, "MXN", "Mexican Peso", 3.9600000000000004, R.drawable.mxn, false),
        CurrencyData(22, "MYR", "Malaysian Ringgit", 3.9600000000000004, R.drawable.myr, false),
        CurrencyData(23, "NOK", "Norwegian Krone", 3.9600000000000004, R.drawable.nok, false),
        CurrencyData(24, "NZD", "New Zealand Dollar", 3.9600000000000004, R.drawable.nzd, false),
        CurrencyData(25, "PHP", "Philippine peso", 3.9600000000000004, R.drawable.php, false),
        CurrencyData(26, "PLN", "Poland złoty", 3.9600000000000004, R.drawable.pln, false),
        CurrencyData(27, "RON", "Romanian Leu", 3.9600000000000004, R.drawable.ron, false),
        CurrencyData(28, "RUB", "Russian Ruble", 3.9600000000000004, R.drawable.rub, false),
        CurrencyData(29, "SEK", "Swedish Krona", 3.9600000000000004, R.drawable.sek, false),
        CurrencyData(30, "SGD", "Singapore Dollar", 3.9600000000000004, R.drawable.sgd, false),
        CurrencyData(31, "THB", "Thai Baht", 3.9600000000000004, R.drawable.thb, false),
        CurrencyData(32, "USD", "United States Dollar", 3.9600000000000004, R.drawable.usd, false),
        CurrencyData(33, "ZAR", "South African Rand", 3.9600000000000004, R.drawable.zar, false)
    )

    @Test
    fun currencyName_currencyCode_returnsCurrencyName() =
        assertThat(
            fakeApiData.asCurrencyData(2.2).toList(),
            IsEqual(currencyData.distinctBy { it.code })
        )
}
