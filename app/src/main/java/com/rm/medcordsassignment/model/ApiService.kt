package com.rm.medcordsassignment.model

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-type:application/json")
    @POST("mhc/test_handle_click")
    fun onButtonPress(@Body postRequest: PostRequest): Single<PostResponse>

}