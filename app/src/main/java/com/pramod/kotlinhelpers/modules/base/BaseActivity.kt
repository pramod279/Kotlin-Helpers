package com.pramod.kotlinhelpers.modules.base

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import com.pramod.kotlinhelpers.KotlinHelperApplication
import com.pramod.kotlinhelpers.common.utils.NetworkReceiver
import com.pramod.kotlinhelpers.common.utils.ProgressIndicator
import com.pramod.kotlinhelpers.common.utils.Toaster.showShortToast

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * Base Activity Class For Kotlin - Helpers
 * Contains commonly used functions
 */

abstract class BaseActivity : AppCompatActivity(), BaseViews, NetworkReceiver.ConnectivityReceiverListener {

    private var progressDialog: ProgressDialog? = null

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

    /**
     * Show Progress Dialog
     */
    override fun showProgress() {
        hideProgress()
        progressDialog = ProgressIndicator.showLoadingIndicator(this)
    }

    /**
     * Dismiss Progress Dialog
     */
    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun onStop() {
        super.onStop()
        (application as KotlinHelperApplication).unregisterConnectivityReceiver()
    }
}