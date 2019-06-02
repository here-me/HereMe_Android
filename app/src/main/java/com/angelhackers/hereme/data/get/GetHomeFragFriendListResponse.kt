package com.angelhackers.hereme.data.get

import com.angelhackers.hereme.data.HomeOverviewData

data class GetHomeFragFriendListResponse (
    val success : Boolean,
    val message: String,
    val friends: ArrayList<HomeOverviewData>
)
