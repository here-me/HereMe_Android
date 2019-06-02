package com.angelhackers.hereme.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager

import com.angelhackers.hereme.R
import com.angelhackers.hereme.adapter.HomeOverviewRecyclerViewAdapter
import com.angelhackers.hereme.data.HomeOverviewData
import com.angelhackers.hereme.data.get.GetHomeFragFriendListResponse
import com.angelhackers.hereme.network.ApplicationController
import com.angelhackers.hereme.network.NetworkService
import kotlinx.android.synthetic.main.fragment_main_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainHomeFragment : Fragment() {

    val networkService : NetworkService by lazy{
        ApplicationController.instance.networkService
    }

    lateinit var homeOverviewRecyclerViewAdapter : HomeOverviewRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var dataList : ArrayList<HomeOverviewData> = ArrayList()

        homeOverviewRecyclerViewAdapter = HomeOverviewRecyclerViewAdapter(context!!,dataList)
        rv_frag_main_home_friend_info.adapter = homeOverviewRecyclerViewAdapter
        rv_frag_main_home_friend_info.layoutManager = LinearLayoutManager(context!!)

        getHomeFragFriendListResponse()
    }

    fun getHomeFragFriendListResponse(){
        val getHomeFragFriendListResponse = networkService.getHomeFragFriendListResponse()
        getHomeFragFriendListResponse.enqueue(object: Callback<GetHomeFragFriendListResponse>{
            override fun onFailure(call: Call<GetHomeFragFriendListResponse>, t: Throwable) {
                Log.e("HomeFragment",t.toString())
            }

            override fun onResponse(
                call: Call<GetHomeFragFriendListResponse>,
                response: Response<GetHomeFragFriendListResponse>
            ) {
                if (response.isSuccessful) {
                    val temp: ArrayList<HomeOverviewData> = response.body()!!.friends!!
                    homeOverviewRecyclerViewAdapter.dataList = temp
                    homeOverviewRecyclerViewAdapter.notifyDataSetChanged()

                }
            }
        })

    }

}
