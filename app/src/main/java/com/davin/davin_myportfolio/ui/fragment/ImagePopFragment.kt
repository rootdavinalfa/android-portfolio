package com.davin.davin_myportfolio.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.davin.davin_myportfolio.R
import com.davin.davin_myportfolio.utils.AssetParser
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class ImagePopFragment : DialogFragment() {
    var image: ImageView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.image_pop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.imagePop)
        Glide.with(this)
            .load(AssetParser().getImageAsset(context!!, "image/davin.jpg"))
            .transition(
                DrawableTransitionOptions()
                    .crossFade()
            ).apply(
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL).override(700, 700)
                    .transform(RoundedCornersTransformation(5, 0))
            ).into(image!!)
    }
}