package com.pramod.kotlinhelpers.common.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.pramod.kotlinhelpers.R

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 *
 * This Object manages the Preference Storage
 * Save & Retrieve Values from the Preference Storage
 * Supported Data Types --> String, Integer, Float, Long, Boolean
 * Clear all Preference
 * Clear a particular preference value
 */

object PreferenceStorage {
    private var sharedPreferences: SharedPreferences? = null
    private var editor: Editor? = null

    fun init(context: Context) {
        init(
            context,
            context.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
    }

    private fun init(context: Context, preferenceName: String, mode: Int) {
        sharedPreferences = context.getSharedPreferences(preferenceName, mode)
        editor = sharedPreferences!!.edit()
        editor!!.apply()
    }

    /**
     * Function for Saving Integer value from Preference Storage
     */
    fun saveString(key: String, value: String) {
        editor!!.putString(key, value)
        editor!!.apply()
    }

    /**
     * Function for Retrieving String value from Preference Storage
     */
    fun getString(key: String?): String? {
        return if (key != null) sharedPreferences!!.getString(key, "") else ""
    }

    /**
     * Function for Saving Integer value from Preference Storage
     */
    fun saveInt(key: String, value: Int) {
        editor!!.putInt(key, value)
        editor!!.apply()
    }

    /**
     * Function for Retrieving Integer value from Preference Storage
     */
    fun getInt(key: String): Int {
        return sharedPreferences!!.getInt(key, 0)
    }

    /**
     * Function for Saving Float value from Preference Storage
     */
    fun saveFloat(key: String, value: Float) {
        editor!!.putFloat(key, value)
        editor!!.apply()
    }

    /**
     * Function for Retrieving Float value from Preference Storage
     */
    fun getFloat(key: String): Float {
        return sharedPreferences!!.getFloat(key, 0f)
    }

    /**
     * Function for Saving Long value from Preference Storage
     */
    fun saveLong(key: String, value: Long) {
        editor!!.putLong(key, value)
        editor!!.apply()
    }

    /**
     * Function for Retrieving Long value from Preference Storage
     */
    fun getLong(key: String): Long {
        return sharedPreferences!!.getLong(key, 0L)
    }

    /**
     * Function for Saving Boolean value from Preference Storage
     */
    fun saveBoolean(key: String, value: Boolean) {
        editor!!.putBoolean(key, value)
        editor!!.apply()
    }

    /**
     * Function for Retrieving Boolean value from Preference Storage
     */
    fun getBoolean(key: String): Boolean {
        return sharedPreferences!!.getBoolean(key, false)
    }

    /**
     * Function for Checking if Preference Store Contains any Value based on the Key
     */
    fun isPreferenceExist(key: String): Boolean {
        return sharedPreferences!!.contains(key)
    }

    /**
     * Function for Removing a Particular Shared Preference Based on The Key
     */
    fun removePreference(key: String) {
        editor!!.remove(key)
        editor!!.apply()
    }

    /**
     * Function for Clearing All Shared Preference
     */
    fun clearPreferenceStorage() {
        editor!!.clear()
        editor!!.apply()
    }
}