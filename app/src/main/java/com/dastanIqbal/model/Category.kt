package com.dastanIqbal.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Category {

    @SerializedName("id")
    @Expose
    var id: Long? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("photo_count")
    @Expose
    var photoCount: Long? = null
    @SerializedName("links")
    @Expose
    var links: Links_? = null

}
