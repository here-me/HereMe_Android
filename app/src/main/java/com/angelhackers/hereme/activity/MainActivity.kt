package com.angelhackers.hereme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.angelhackers.hereme.adapter.ProductMainPagerAdapter
import com.angelhackers.hereme.data.get.GetTestResponse
import com.angelhackers.hereme.network.ApplicationController
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    val networkService by lazy {
        ApplicationController.instance.networkService
    }
    private lateinit var getTestResponse: Call<GetTestResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureMainTab()
        setDate()
        // getTestResponse()
    }

    private fun setDate()
    {
            val now = System.currentTimeMillis()
            val date = Date(now)
            val sdfNow = SimpleDateFormat("MM월 dd일")
            val formatDate = sdfNow.format(date)
            val dateNow: TextView = findViewById(R.id.txt_toolbar_main_date)
            dateNow.setText(formatDate)

    }

    private fun configureMainTab() {
        vp_main_home.adapter = ProductMainPagerAdapter(supportFragmentManager, 3)
        vp_main_home.offscreenPageLimit = 2
        tl_main_home.setupWithViewPager(vp_main_home)


        val navCategoryMainLayout: View =
            (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.navigation_home_main, null, false)
        tl_main_home.getTabAt(0)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_nav_main_home)
        tl_main_home.getTabAt(1)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_nav_main_friend_list)
        tl_main_home.getTabAt(2)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_nav_main_setting)
    }
//    static View v; // 프래그먼트의 뷰 인스턴스
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        if(v!=null){
//            ViewGroup parent = (ViewGroup)v.getParent();
//            if(parent!=null){
//                parent.removeView(v);
//            }
//        }
//    }

//    private fun getTestResponse() {
//        getTestResponse = networkService.getTestResponse()
//        getTestResponse.enqueue(object : Callback<GetTestResponse> {
//            override fun onFailure(call: Call<GetTestResponse>, t: Throwable) {
//                Log.e("Mypage-Scrap failed", t.toString())
//            }
//
//            override fun onResponse(call: Call<GetTestResponse>, response: Response<GetTestResponse>) {
//                if (response.isSuccessful) {
//                        toast(response.body()!!.message)
//                }
//
//            }
//        })
//    }
}