package com.dastanIqbal.all4one.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.dastanIqbal.all4one.R
import com.dastanIqbal.all4one.databinding.RvitemBinding
import com.dastanIqbal.model.DataM
import com.dastaniqbal.library.Fetch
import com.dastaniqbal.library.request.ImageRequest
import com.dastaniqbal.library.request.MediaType

class ItemViewHolder(private val binding: RvitemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dataM: DataM) {
        binding.textView.text = dataM.user?.name ?: "No name"

        dataM.user?.profileImage?.medium?.let {
            Fetch.asImage().eneque(
                ImageRequest(
                    it,
                    MediaType.IMAGE
                ).apply {
                callback = { bmp ->
                    if (bmp.width > 0 && bmp.height > 0)
                        binding.imageView.setImageBitmap(bmp)
                    else binding.imageView.setImageResource(R.mipmap.ic_avatar)
                }
            })
        } ?: binding.imageView.setImageResource(R.mipmap.ic_avatar)
    }
}