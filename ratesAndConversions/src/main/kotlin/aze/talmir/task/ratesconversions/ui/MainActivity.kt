package aze.talmir.task.ratesconversions.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import aze.talmir.task.ratesconversions.databinding.MainActivityBinding

// App logo have taken from:
// https://www.flaticon.com/free-icon/currency_2258454?term=exchange%20rate&page=1&position=10
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MainActivityBinding.inflate(layoutInflater).root)
    }
}
