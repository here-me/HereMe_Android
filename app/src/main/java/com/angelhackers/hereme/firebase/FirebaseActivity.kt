package com.angelhackers.hereme.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.angelhackers.hereme.R
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_firebase.*
import org.jetbrains.anko.toast

class FirebaseActivity : AppCompatActivity() {

    val TAG : String = "FirebaseActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)
        setOnBtnClickListener()
    }
    fun setOnBtnClickListener(){
        btn_act_firebase_get.setOnClickListener {
            var token : String = FirebaseInstanceId.getInstance().getToken()!!
            Log.d(TAG,token)
            toast(token)
        }
    }
}
