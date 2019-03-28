package com.pramod.kotlinhelpers

import android.app.Application

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * This is the Preference Storage Application Class
 */
class KotlinHelperApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        /**
         * Initialise Preference Storage
         */
        PreferenceStorage.init(this)
    }
}