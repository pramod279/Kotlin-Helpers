package com.pramod.kotlinhelpers.modules.base

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
     * Show Progress Loader
     */
    fun showProgress()

    /**
     * Hide Progress Loader
     */
    fun hideProgress()
}