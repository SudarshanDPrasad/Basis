package com.application.basis.di

import com.application.basis.api.ApiClient
import com.application.basis.local.data.ResponseModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.google.gson.GsonBuilder

import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object MovieModule {


    @Singleton
    @Provides
    suspend fun ProvidesApi(): ResponseModel {

        val gson = GsonBuilder()
            .setLenient()
            .create()


        val builder = Retrofit.Builder()
            .baseUrl("https://git.io/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


        var response : String = builder.create(ApiClient::class.java).getResponse()

        var data: String = response.substring(1)

        val responseModel = Gson().fromJson(
            data,
            ResponseModel::class.java
        )

        return responseModel
    }
}
