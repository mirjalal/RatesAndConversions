package aze.talmir.task.ratesconversions.ui.main.adapter

import android.text.TextWatcher
import android.view.View
import aze.talmir.task.ratesconversions.data.model.CurrencyData

/**
 * A click listener class to handle repository items' clicks
 */
class CurrencyDataItemClickEvent(val clickListener: (currencyDataItem: CurrencyData) -> Unit) {
    /**
     * A function that will be fired on recycler views' each item click.
     */
    fun onCurrencyDataItemClick(currencyDataItem: CurrencyData) = clickListener(currencyDataItem)
}

class CurrencyDataItemAmountChangeEvent {
    lateinit var focusChangeListener: (v: View, hasFocus: Boolean) -> Unit
    lateinit var textChangeListener: TextWatcher // (text: CharSequence?, start: Int, count: Int, after: Int) -> Unit
}
