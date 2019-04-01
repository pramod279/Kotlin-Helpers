package com.pramod.kotlinhelpers.modules.base

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.pramod.kotlinhelpers.R
import com.pramod.kotlinhelpers.common.receivers.NetworkReceiver
import com.pramod.kotlinhelpers.common.utils.ProgressIndicator
import com.pramod.kotlinhelpers.common.utils.Toaster.showShortToast
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * Base Activity Class For Kotlin - Helpers
 * Contains commonly used functions
 */

abstract class BaseActivity : AppCompatActivity(), BaseViews, NetworkReceiver.ConnectivityReceiverListener {
    private var networkReceiver = NetworkReceiver()
    private var progressDialog: ProgressDialog? = null

    @SuppressLint("InflateParams")
    override fun setContentView(layoutResID: Int) {
        val baseLayout: CoordinatorLayout =
            layoutInflater.inflate(R.layout.activity_base, null) as CoordinatorLayout
        val baseContainer: FrameLayout = baseLayout.findViewById(R.id.layout_container)
        layoutInflater.inflate(layoutResID, baseContainer, true)
        super.setContentView(baseLayout)
    }

    override fun onResume() {
        super.onResume()
        NetworkReceiver.connectivityReceiverListener = this
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(networkReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(networkReceiver)
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
     * Set Toolbar Title
     */
    override fun setToolBarTitle(toolbarTitle: String) {
        toolbar_title.text = toolbarTitle
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
}