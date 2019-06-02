package com.angelhackers.hereme.network

import com.angelhackers.hereme.data.get.GetHomeFragFriendListResponse
import com.angelhackers.hereme.data.get.GetTestResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface NetworkService {
    //get Test
    @GET("/")
    fun getTestResponse(
    ): Call<GetTestResponse>

    //친구 리스트 불러오기
    @GET("/friends")
    fun getHomeFragFriendListResponse(
    ): Call<GetHomeFragFriendListResponse>


}
