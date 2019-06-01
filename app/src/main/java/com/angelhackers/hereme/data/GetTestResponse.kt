package com.angelhackers.hereme.data

data class GetTestResponse(
    val status : String,
    val data : Array<String>,
    val params : ArrayList<GetTestResponseData>
)

data class  GetTestResponseData(
    val handler: String,
    val private_key: String,
    val public_key: String,
    val to: String,
    val value: String,
    val transactional_data : String,
    val transaction : String,
    val signature: String
)