package com.example.xboxliveprofile.Data

import com.google.gson.annotations.SerializedName

data class ModelXboxLive(
    @SerializedName("data"       ) var data       : Data?       = Data(),
    @SerializedName("additional" ) var additional : Additional? = Additional()
)
