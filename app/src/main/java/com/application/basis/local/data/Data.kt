package com.application.basis.local.data


import com.google.gson.annotations.SerializedName

open class Data(
    @SerializedName("id")
    var id: String,
    @SerializedName("text")
    val text: String
)