package com.application.basis.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * Calling Response through API
 */
interface ApiClient {


    @GET("fjaqJ")
    fun getResponse() : Single<String>

}