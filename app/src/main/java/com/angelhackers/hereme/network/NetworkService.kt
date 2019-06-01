package com.angelhackers.hereme.network

import com.angelhackers.hereme.data.get.GetTestResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface NetworkService {
    //get Test
    @GET("/")
    fun getTestResponse(
    ): Call<GetTestResponse>


}
