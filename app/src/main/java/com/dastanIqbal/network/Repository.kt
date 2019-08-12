package com.dastanIqbal.network

import com.dastanIqbal.model.DataM
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor(private val repoService: ApiService) {


    fun getData(): Single<List<DataM>> {
        return repoService.getData()
    }
}