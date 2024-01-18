package com.ekaterinabaygin.countryflags

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ekaterinabaygin.flag.R

private val requiredCountries = listOf(
    "at",
    "pl",
    "it",
    "co",
    "mg",
    "th",
    "dk",
    "se"
)

class MainActivity : AppCompatActivity() {

    private val countryAdapter by lazy(LazyThreadSafetyMode.NONE) { CountryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        loadCountries()
    }

    private fun initView() {
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = countryAdapter
        }
    }

    private fun loadCountries() {
        countryAdapter.submitList(requiredCountries.map(Country::fromCountryCode))
    }
}
