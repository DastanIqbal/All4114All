package com.dastanIqbal.network

import com.dastanIqbal.model.DataM
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("raw/wgkJgazE")
    fun getData(): Single<List<DataM>>
}