package com.angelhackers.hereme.network

import com.angelhackers.hereme.data.GetTestResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST


interface NetworkService {
//get Test
@GET("/")
fun getTestResponse(
): Call<GetTestResponse>
}