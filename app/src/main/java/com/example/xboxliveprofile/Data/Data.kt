package com.example.xboxliveprofile.Data

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("player" ) var player : Player? = Player(),
    @SerializedName("status" ) var status : Status? = Status()
)
