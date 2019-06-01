package com.angelhackers.hereme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.angelhackers.hereme.data.GetTestResponse
import com.angelhackers.hereme.network.ApplicationController
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    val networkService by lazy {
        ApplicationController.instance.networkService
    }
    private lateinit var getTestResponse: Call<GetTestResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_act_main_toMap.setOnClickListener {
            val nextIntent = Intent(this, MapsActivity::class.java)
            startActivity(nextIntent)
        }

        btnn.setOnClickListener {
            getTestResponse()

        }
    }

    private fun getTestResponse() {
        getTestResponse = networkService.getTestResponse()
        getTestResponse.enqueue(object : Callback<GetTestResponse> {
            override fun onFailure(call: Call<GetTestResponse>, t: Throwable) {
                Log.e("Mypage-Scrap failed", t.toString())
            }

            override fun onResponse(call: Call<GetTestResponse>, response: Response<GetTestResponse>) {
                if (response.isSuccessful) {
                        toast(response.body()!!.message)
                }

            }
        })
    }
}