package com.example.xboxliveprofile.Data

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("success" ) var success : Boolean? = null,
    @SerializedName("reason"  ) var reason  : String?  = null
)
