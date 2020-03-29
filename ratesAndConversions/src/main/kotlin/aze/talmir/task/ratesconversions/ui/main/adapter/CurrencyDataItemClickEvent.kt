package aze.talmir.task.ratesconversions.ui.main.adapter

import aze.talmir.task.ratesconversions.data.model.CurrencyData

/**
 * A click listener class to handle repository items' clicks.
 */
class CurrencyDataItemClickEvent(val clickListener: (currencyDataItem: CurrencyData) -> Unit) {
    /**
     * A function that will be fired on recycler views' each item click.
     */
    fun onCurrencyDataItemClick(currencyDataItem: CurrencyData) = clickListener(currencyDataItem)
}
