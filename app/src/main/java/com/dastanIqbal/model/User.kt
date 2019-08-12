package com.dastanIqbal.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("profile_image")
    @Expose
    var profileImage: ProfileImage? = null
    @SerializedName("links")
    @Expose
    var links: Links? = null

}
