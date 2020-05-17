package com.rm.medcordsassignment.model

import io.reactivex.Single
import javax.inject.Inject

class NetworkRepoImpl @Inject constructor(private val apiService: ApiService) : INetworkRepo {
    override fun getApiData(text: String): Single<PostResponse> {

        var request = PostRequest()
        request.buttonName = text
        return apiService.onButtonPress(request)
    }

}