package com.dastanIqbal.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataM {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("width")
    @Expose
    var width: Long? = null
    @SerializedName("height")
    @Expose
    var height: Long? = null
    @SerializedName("color")
    @Expose
    var color: String? = null
    @SerializedName("likes")
    @Expose
    var likes: Long? = null
    @SerializedName("liked_by_user")
    @Expose
    var likedByUser: Boolean? = null
    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("current_user_collections")
    @Expose
    var currentUserCollections: List<Any>? = null
    @SerializedName("urls")
    @Expose
    var urls: Urls? = null
    @SerializedName("categories")
    @Expose
    var categories: List<Category>? = null
    @SerializedName("links")
    @Expose
    var links: Links__? = null

}
