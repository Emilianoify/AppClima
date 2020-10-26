package com.stay.hearthweather.helpers

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {
    val PREFS_NAME = "com.stay.hearthweather.helpers.sharedpreferences"
    val TOKEN_KEY = "token_key"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)
    val opcionKey = "opcion_key"

    var opcion: String?
        get() = prefs.getString(TOKEN_KEY, "")
        set(value) = prefs.edit().putString(TOKEN_KEY, value).apply()
    var selectedOption: Boolean
        get() = prefs.getBoolean(opcionKey, false)
        set(value) = prefs.edit().putBoolean(opcionKey, value).apply()

}