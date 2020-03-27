package aze.talmir.task.ratesconversions.ui.main.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import aze.talmir.task.ratesconversions.data.model.CurrencyData

@BindingAdapter("currencyDataItemIcon")
fun ImageView.setCurrencyDataItemIcon(currencyDataItem: CurrencyData) {
    setImageResource(currencyDataItem.flag)
}
