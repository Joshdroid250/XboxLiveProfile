package com.example.xboxliveprofile.Data

import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("gamertag"     ) var gamertag    : String? = null,
    @SerializedName("gamerpic_url" ) var gamerpicUrl : String? = null
)
