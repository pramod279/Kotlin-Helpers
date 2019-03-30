package com.pramod.kotlinhelpers.common.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * This class manages the Toast Messages
 */

object Toaster {

    /**
     * Function for showing Short Toast Message
     */
    fun Context.showShortToast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    /**
     * Function for Showing Long Toast Message
     */
    fun Context.showLongToast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}