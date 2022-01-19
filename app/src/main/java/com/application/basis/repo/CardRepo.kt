package com.application.basis.repo

import com.application.basis.api.ApiClient
import com.application.basis.di.MovieModule
import com.application.basis.local.data.ResponseModel
import com.application.sunstonekotlinassignment.data.Resource
import com.application.sunstonekotlinassignment.data.ResponseHandler
import dagger.Module
import javax.inject.Inject

open class CardRepo @Inject constructor() {

    var responseHandler = ResponseHandler()

    suspend fun getData(): Resource<ResponseModel> {
        val data = MovieModule.ProvidesApi()
        return try {
            responseHandler.handleSuccess(data)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

}