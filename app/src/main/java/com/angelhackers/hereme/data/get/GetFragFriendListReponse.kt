package com.angelhackers.hereme.data.get

import com.angelhackers.hereme.data.FriendListMainData

data class GetFragFriendListResponse (
    val success : Boolean,
    val message: String,
    val friends: ArrayList<FriendListMainData>
)
