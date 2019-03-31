package com.pramod.kotlinhelpers.common.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.pramod.kotlinhelpers.R

/**
 * Created by PRAMOD SELVARAJ on 25-03-2019.
 * This is the Glide Image Loader Extension
 */

internal fun ImageView.loadGlideImage(imageURL: String, placeHolderID: Int) {
    Glide.with(this.context)
        .load(imageURL)
        .centerCrop()
        .placeholder(placeHolderID)
        .into(this)
}