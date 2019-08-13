package com.dastanIqbal.all4one.feature.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.dastanIqbal.all4one.R
import com.dastanIqbal.all4one.databinding.RvitemBinding
import com.dastanIqbal.di.adapter.DataBoundListAdapter
import com.dastanIqbal.model.DataM
import com.dastaniqbal.library.Fetch
import com.dastaniqbal.library.request.ImageRequest
import com.dastaniqbal.library.request.MediaType

class ItemAdapter :
    DataBoundListAdapter<DataM, RvitemBinding>(
        diffCallback = object : DiffUtil.ItemCallback<DataM>() {
            override fun areItemsTheSame(oldItem: DataM, newItem: DataM): Boolean {
                return oldItem.user?.id == newItem.user?.id
            }

            override fun areContentsTheSame(oldItem: DataM, newItem: DataM): Boolean {
                return oldItem.user?.id == newItem.user?.id ||
                        oldItem.user?.username == newItem.user?.username ||
                        oldItem.user?.name == newItem.user?.name ||
                        oldItem.user?.links?.self == newItem.user?.links?.self
            }
        }

    ) {
    override fun createBinding(parent: ViewGroup) = RvitemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )

    override fun bind(binding: RvitemBinding, item: DataM, position: Int) {
        bind(binding, item)
    }

    private fun bind(binding: RvitemBinding, dataM: DataM) {
        binding.textView.text = dataM.user?.name ?: "No name"

        dataM.user?.profileImage?.large?.let {
            Fetch.asImage().eneque(
                ImageRequest(
                    it,
                    MediaType.IMAGE
                ).apply {
                    callback = { bmp ->
                        if (bmp.width > 0 && bmp.height > 0)
                            binding.imageView.setImageBitmap(bmp)
                        else binding.imageView.setImageResource(R.mipmap.ic_avatar)
                        binding.pbLoading.visibility = View.GONE
                    }
                })
        } ?: binding.imageView.setImageResource(R.mipmap.ic_avatar)
    }
}