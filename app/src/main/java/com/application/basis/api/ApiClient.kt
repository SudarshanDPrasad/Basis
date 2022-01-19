package com.application.basis.api

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiClient {

    @GET("fjaqJ")
    suspend fun getResponse() : String

}