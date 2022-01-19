package com.application.basis.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.application.basis.api.ApiClient
import com.application.basis.di.MovieModule.ProvidesApi
import com.application.basis.local.data.ResponseModel
import com.application.sunstonekotlinassignment.data.Resource
import com.application.sunstonekotlinassignment.data.ResponseHandler
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

open class CardRepo @Inject constructor() {

    var responseHandler = ResponseHandler()
    val mutableLiveData = MutableLiveData<Resource<ResponseModel>>()

    fun getDatafromAPI(): LiveData<Resource<ResponseModel>> {

        ProvidesApi().create(ApiClient::class.java).getResponse()
            .map { unfilteredJson -> unfilteredJson.substring(1) } // The File Before removing the " / "
            .map { filteredJson -> Gson().fromJson(filteredJson,ResponseModel::class.java) } // The file After removing the " /"
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<ResponseModel>{
                override fun onSubscribe(d: Disposable?) {

                }

                override fun onSuccess(t: ResponseModel?) {
                    mutableLiveData.value = responseHandler.handleSuccess(t!!)
                }

                override fun onError(e: Throwable?) {
                    responseHandler.handleException<Throwable>(e!!)
                }

            })

        return mutableLiveData
    }

}