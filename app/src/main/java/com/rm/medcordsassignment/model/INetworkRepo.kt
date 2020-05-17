package com.rm.medcordsassignment.model

import io.reactivex.Single

interface INetworkRepo {
    fun getApiData(text: String): Single<PostResponse>
}