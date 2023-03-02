package com.example.besinlerkitabi.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class OzelSharedPreferences {
    companion object {
        private var ZAMAN = "zaman"
        private var sharedPrefences: SharedPreferences? = null
        @Volatile private var instance: OzelSharedPreferences? = null

        private val lock = Any()
        operator fun invoke(context: Context): OzelSharedPreferences = instance ?: synchronized(lock)
            {
                instance ?: ozelSharedPrefencesYap(context).also {
                    instance = it
                }
            }

        private fun ozelSharedPrefencesYap(context: Context): OzelSharedPreferences {
            sharedPrefences =androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
            return OzelSharedPreferences()
        }
    }

    fun zamaniKaydet(zaman: Long) {
         sharedPrefences?.edit(commit = true) {
            putLong(ZAMAN, zaman)

        }
    }

    fun zamaniAl() = sharedPrefences?.getLong(ZAMAN, 0)
}