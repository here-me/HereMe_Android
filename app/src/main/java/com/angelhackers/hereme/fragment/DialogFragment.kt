package com.angelhackers.hereme.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.angelhackers.hereme.MainActivity

import com.angelhackers.hereme.R
import kotlinx.android.synthetic.main.fragment_dialog.*

class DialogFragment(val ctx : Context) : AlertDialog(ctx){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_dialog)
        btn_frag_dialog_submit.setOnClickListener {

            dismiss()
        }
    }
}
