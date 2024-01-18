package com.ekaterinabaygin.countryflags

import java.util.Locale

private const val FLAG_OFFSET = 0x1F1E6
private const val ASCII_OFFSET = 0x41

data class Country(
    val countryCode: String,
    val flag: String,
    val name: String
) {

    companion object {
        fun fromCountryCode(countryCode: String) = with(countryCode.uppercase()) {
            Country(
                countryCode = this,
                flag = getFlagForCode(this),
                name = getCountryForCode(this)
            )
        }

        private fun getFlagForCode(countryCode: String): String {
            val resultCode = countryCode.uppercase()
            val firstChar = Character.codePointAt(resultCode, 0) - ASCII_OFFSET + FLAG_OFFSET
            val secondChar = Character.codePointAt(resultCode, 1) - ASCII_OFFSET + FLAG_OFFSET
            return String(Character.toChars(firstChar)) + String(Character.toChars(secondChar))
        }

        private fun getCountryForCode(countryCode: String): String {
            return Locale("", countryCode).displayCountry
        }
    }
}

