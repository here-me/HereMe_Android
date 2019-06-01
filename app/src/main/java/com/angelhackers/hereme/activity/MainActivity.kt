package com.angelhackers.hereme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
//    val networkService by lazy {
//        ApplicationController.instance.networkService
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_act_main_toMap.setOnClickListener {
            val nextIntent = Intent(this, MapsActivity::class.java)
            startActivity(nextIntent)
        }

       // getTestResponse()
    }

//    private fun getTestResponse(){
//val getTestResponse = networkService.getTestResponse()
//        getTestResponse.enqueue(object : Callback<GetTestResponse> {
//            override fun onFailure(call: Call<GetTestResponse>, t: Throwable) {
//                Log.e("Mypage-Scrap failed", t.toString())
//            }
//
//            override fun onResponse(call: Call<GetTestResponse>, response: Response<GetTestResponse>) {
//                if (response.isSuccessful)
//                        toast(response.body()!!.data.toString())
//
//
//            }
//        })
//
//    }
}