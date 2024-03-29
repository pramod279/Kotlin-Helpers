package com.pramod.kotlinhelpers.common.utils

import android.app.Activity
import android.util.Log
import com.pramod.kotlinhelpers.BuildConfig

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * This is the Logger Helper Extension
 */

/**
 * Debug Log
 */
fun Activity.loggerD(message: String) {
    if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, message)
}

/**
 * Error Log
 */
fun Activity.loggerE(message: String) {
    if (BuildConfig.DEBUG) Log.e(this::class.java.simpleName, message)
}

/**
 * Info Log
 */
fun Activity.loggerI(message: String) {
    if (BuildConfig.DEBUG) Log.i(this::class.java.simpleName, message)
}

/**
 * Verbose Log
 */
fun Activity.loggerV(message: String) {
    if (BuildConfig.DEBUG) Log.v(this::class.java.simpleName, message)
}