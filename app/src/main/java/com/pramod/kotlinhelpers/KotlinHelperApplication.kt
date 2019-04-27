package com.pramod.kotlinhelpers

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.pramod.kotlinhelpers.common.data.preferences.PreferenceStorage
import io.fabric.sdk.android.Fabric


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

        /**
         * Initialise Crashlytics
         */
        Fabric.with(this, Crashlytics())
    }
}