package com.pramod.kotlinhelpers.common.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import androidx.core.graphics.drawable.toDrawable
import com.pramod.kotlinhelpers.R

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * This class handles the Progress Indicator
 */

object ProgressIndicator {
    /**
     * Trigger Progress Indicator
     */
    fun showLoadingIndicator(context: Context?): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.let {
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.progress_indicator)
            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }
}