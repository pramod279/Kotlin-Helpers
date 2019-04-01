package com.pramod.kotlinhelpers.uimodules.home

import android.os.Bundle
import android.view.View
import com.pramod.kotlinhelpers.R
import com.pramod.kotlinhelpers.common.data.preferences.PreferenceConstants
import com.pramod.kotlinhelpers.common.data.preferences.PreferenceStorage
import com.pramod.kotlinhelpers.common.utils.Toaster.showShortToast
import com.pramod.kotlinhelpers.common.utils.loadGlideImage
import com.pramod.kotlinhelpers.common.utils.loggerD
import com.pramod.kotlinhelpers.uimodules.base.BaseActivity
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
         * Show Progress Indicator
         */
        showProgress()

        /**
         * Hide Progress Indicator
         */
        //hideProgress()

        /**
         * Load Image URL Using Glide
         */
        glide_image_avatar.loadGlideImage(
            "https://crackberry.com/sites/crackberry.com" +
                    "/files/topic_images/2013/ANDROID.png", R.drawable.ic_launcher_background
        )

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
        if (isConnected) {
            hello_world.text = "You are Online !!!"
            hello_world.visibility = View.VISIBLE
            glide_image_avatar.visibility = View.VISIBLE
            no_network.visibility = View.GONE
        } else {
            hello_world.text = "You are Offline !!!"
            hello_world.visibility = View.GONE
            glide_image_avatar.visibility = View.GONE
            no_network.visibility = View.VISIBLE
        }
    }
}