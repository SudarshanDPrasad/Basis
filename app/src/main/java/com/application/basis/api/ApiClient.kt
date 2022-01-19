package com.application.basis.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiClient {

    @GET("fjaqJ")
    fun getResponse() : Single<String>

}