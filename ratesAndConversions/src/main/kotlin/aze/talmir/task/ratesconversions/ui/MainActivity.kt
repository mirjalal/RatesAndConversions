package aze.talmir.task.ratesconversions.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import aze.talmir.task.ratesconversions.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MainActivityBinding.inflate(layoutInflater).root)
    }
}
