package com.angelhackers.hereme.data

data class FriendListMainData(
    var id: Int,
    var image_url: String,
    var temp: Int,
    var name: String,
    var locate_name: String,
    var image_status: String,
    var humi: Int,
    var rain: Int,
    var isGood: String
)