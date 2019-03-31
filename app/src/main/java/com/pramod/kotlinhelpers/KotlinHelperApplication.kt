package com.pramod.kotlinhelpers

import android.app.Application
import android.content.IntentFilter
import android.net.ConnectivityManager
import com.crashlytics.android.Crashlytics
import com.pramod.kotlinhelpers.common.utils.NetworkReceiver
import com.pramod.kotlinhelpers.common.utils.PreferenceStorage
import io.fabric.sdk.android.Fabric

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * This is the Preference Storage Application Class
 */
class KotlinHelperApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        /**
         * Network Connectivity Broadcast Receiver
         */
        registerReceiver(NetworkReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        /**
         * Initialise Preference Storage
         */
        PreferenceStorage.init(this)

        /**
         * Initialise Crashlytics
         */
        Fabric.with(this, Crashlytics())
    }

    /**
     * Function for Unregistering Network Connectivity Receiver
     */
    fun unregisterConnectivityReceiver() {
        unregisterReceiver(NetworkReceiver())
    }
}