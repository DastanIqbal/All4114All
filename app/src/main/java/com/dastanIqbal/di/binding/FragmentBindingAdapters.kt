package com.dastanIqbal.di.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import javax.inject.Inject

/**
 * Binding adapters that work with a fragment instance.
 */
class FragmentBindingAdapters @Inject constructor(val fragment: androidx.fragment.app.Fragment) {
    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String) {

    }
}
