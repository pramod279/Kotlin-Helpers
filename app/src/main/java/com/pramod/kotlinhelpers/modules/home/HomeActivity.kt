package com.pramod.kotlinhelpers.modules.home

import android.os.Bundle
import com.pramod.kotlinhelpers.R
import com.pramod.kotlinhelpers.common.constants.PreferenceConstants
import com.pramod.kotlinhelpers.common.utils.PreferenceStorage
import com.pramod.kotlinhelpers.common.utils.Toaster.showShortToast
import com.pramod.kotlinhelpers.common.utils.loggerD
import com.pramod.kotlinhelpers.modules.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * This class shows how to Save & Retrieve values from Preference Storage
 */

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Saving Values to Preference Storage
         */
        PreferenceStorage.saveString(PreferenceConstants.PREF_NAME, "Pramod Selvaraj")
        PreferenceStorage.saveInt(PreferenceConstants.PREF_AGE, 27)

        /**
         * Fetching Values from Preference Storage
         */
        val name: String? = PreferenceStorage.getString(PreferenceConstants.PREF_NAME)
        val age: Int? = PreferenceStorage.getInt(PreferenceConstants.PREF_AGE)
        val message = """$name $age"""

        hello_world.text = message

        /**
         * Show Short Toast Message
         */
        showShortToast("Hello World !!!")

        /**
         * Logger
         */
        loggerD("Hello World !!!")
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        super.onNetworkConnectionChanged(isConnected)
        if (isConnected) hello_world.text = "You are Online !!!" else hello_world.text = "You are Offline !!!"
    }
}