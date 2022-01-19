package com.application.basis.local.data


import com.application.basis.local.data.Data
import com.google.gson.annotations.SerializedName

open class ResponseModel(
    @SerializedName("data")
    val data: List<Data>
)