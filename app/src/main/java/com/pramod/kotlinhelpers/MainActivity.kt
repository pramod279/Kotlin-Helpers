package com.pramod.kotlinhelpers

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pramod.kotlinhelpers.Toaster.showShortToast

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * This class shows how to Save & Retrieve values from Preference Storage
 */

class MainActivity : AppCompatActivity() {

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

        val textView: TextView = findViewById(R.id.id_hello_world)
        textView.text = message

        /**
         * Show Short Toast Message
         */
        showShortToast("Hello World !!!")
    }
}