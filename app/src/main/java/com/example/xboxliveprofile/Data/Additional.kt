package com.example.xboxliveprofile.Data

import com.google.gson.annotations.SerializedName

data class Additional(
    @SerializedName("parameters" ) var parameters : Parameters? = Parameters()
)
