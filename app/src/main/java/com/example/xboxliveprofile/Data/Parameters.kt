package com.example.xboxliveprofile.Data

import com.google.gson.annotations.SerializedName

data class Parameters(
    @SerializedName("gamertag" ) var gamertag : String? = null
)
