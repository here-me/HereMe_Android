package com.angelhackers.hereme.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface NetworkService {
//get Test
@GET("/search/cafe/{keyword}")
fun getTest(
    @Path("keyword") keyword: String
): Call<>
}