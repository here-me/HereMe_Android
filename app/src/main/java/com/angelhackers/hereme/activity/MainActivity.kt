package com.angelhackers.hereme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_act_main_toMap.setOnClickListener {
            val nextIntent = Intent(this, MapsActivity::class.java)
            startActivity(nextIntent)
        }

    }


}