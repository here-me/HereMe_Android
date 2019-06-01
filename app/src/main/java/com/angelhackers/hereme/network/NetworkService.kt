package com.angelhackers.hereme.network

import com.angelhackers.hereme.data.GetTestResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface NetworkService {
//get Test
@GET("/simple/sendcointest?private_key=e201ef79c6dd79b7611d94b4ba877d7c18855a60aaa7cf6b00057a726456336c&public_key=82df74db81fd0c1072aa0a6679a9ad34b36899044512c68b13edc0d91dcbee7d&to=0x6f23163d158d1a853f63a54062fa34ec0bb05048ab4031&value=0.2&transactional_data=-")
fun getTestResponse(
): Call<GetTestResponse>
}