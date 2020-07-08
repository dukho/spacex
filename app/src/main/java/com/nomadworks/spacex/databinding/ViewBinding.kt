package com.nomadworks.spacex.databinding

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBinding {
    @JvmStatic
    @BindingAdapter("backgroundDrawable")
    fun setImageSrc(view: View, resId: Int) {
        view.setBackgroundResource(resId)
    }

    @JvmStatic
    @BindingAdapter("visibleOrGone")
    fun setVisibleOrGone(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("visibleOrInvisible")
    fun setVisibleOrInvisible(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }
}