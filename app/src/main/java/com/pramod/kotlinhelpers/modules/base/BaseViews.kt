package com.pramod.kotlinhelpers.modules.base

import android.widget.ImageButton

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * Base Activity Views
 */

interface BaseViews {

    /**
     * Set Toolbar Title
     */
    fun setToolBarTitle(toolbarTitle: String)

    /**
     * Left Toolbar Controller
     */
    fun leftToolbarController(): ImageButton

    /**
     * Show Progress Loader
     */
    fun showProgress()

    /**
     * Hide Progress Loader
     */
    fun hideProgress()
}