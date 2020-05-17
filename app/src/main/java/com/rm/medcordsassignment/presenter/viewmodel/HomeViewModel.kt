package com.rm.medcordsassignment.presenter.viewmodel

import androidx.lifecycle.ViewModel
import com.rm.medcordsassignment.model.INetworkRepo
import com.rm.medcordsassignment.model.PostResponse
import io.reactivex.Single
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val iNetworkRepo: INetworkRepo) : ViewModel() {

    fun getApiData(text: String): Single<PostResponse> {
        return iNetworkRepo.getApiData(text)
    }
}

