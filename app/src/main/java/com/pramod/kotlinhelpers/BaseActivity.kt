package com.pramod.kotlinhelpers

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pramod.kotlinhelpers.Toaster.showShortToast

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * Base Activity Class For Kotlin - Helpers
 * Contains commonly used functions
 * 1) Network State Change Receivers
 */

open class BaseActivity : AppCompatActivity(), NetworkReceiver.ConnectivityReceiverListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(
            NetworkReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }

    override fun onResume() {
        super.onResume()
        NetworkReceiver.connectivityReceiverListener = this
    }

    /**
     * Network State Change Listener Trigger
     */
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        isOnline(isConnected)
    }

    /**
     * Network Status Online
     */
    private fun isOnline(isConnected: Boolean) {
        return if (isConnected) showShortToast("You are Online !!!") else showShortToast("You are Offline !!!")
    }
}