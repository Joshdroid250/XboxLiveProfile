package com.example.xboxliveprofile

import com.example.xboxliveprofile.Data.ModelXboxLive
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getStatsXboxLive(@Url url:String): Response<ModelXboxLive>
}