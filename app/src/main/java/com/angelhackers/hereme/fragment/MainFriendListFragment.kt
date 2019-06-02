package com.angelhackers.hereme.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.angelhackers.hereme.R
import com.angelhackers.hereme.adapter.FriendListMainAdapter
import com.angelhackers.hereme.data.FriendListMainData
import com.angelhackers.hereme.data.get.GetFragFriendListResponse
import com.angelhackers.hereme.data.get.GetRes
import com.angelhackers.hereme.network.ApplicationController
import com.angelhackers.hereme.network.NetworkService
import kotlinx.android.synthetic.main.fragment_main_friend_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFriendListFragment : Fragment() {

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    lateinit var friendListMainAdapter: FriendListMainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_friend_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var dataList: ArrayList<FriendListMainData> = ArrayList()

        friendListMainAdapter = FriendListMainAdapter(context!!, dataList)
        act_frag_main_friend_list_recycle.adapter = friendListMainAdapter
        act_frag_main_friend_list_recycle.layoutManager = LinearLayoutManager(context!!)

        var mHandler: Handler? = null

        @SuppressLint("HandlerLeak")
        mHandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                getFragFriendListResponse()
            }
        }

        thread(start = true) {
            while (true) {
                Thread.sleep(1000)
                mHandler?.sendEmptyMessage(0)
                break;
            }
        }


    }

    fun getFragFriendListResponse() {
        val getFragFriendListResponse = networkService.getFragFriendListResponse()
        getFragFriendListResponse.enqueue(object : Callback<GetFragFriendListResponse> {
            override fun onFailure(call: Call<GetFragFriendListResponse>, t: Throwable) {
                Log.e("FriendFragment", t.toString())
            }

            override fun onResponse(
                call: Call<GetFragFriendListResponse>,
                response: Response<GetFragFriendListResponse>
            ) {
                if (response.isSuccessful) {
                    val temp: ArrayList<FriendListMainData> = response.body()!!.friends!!
                    friendListMainAdapter.dataList = temp
                    friendListMainAdapter.notifyDataSetChanged()

                }
            }
        })

    }

}
