package com.angelhackers.hereme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.angelhackers.hereme.R
import com.angelhackers.hereme.data.FriendListMainData
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class FriendListMainAdapter (var ctx : Context, var dataList: ArrayList<FriendListMainData>) : RecyclerView.Adapter<FriendListMainAdapter.Holder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.fragment_main_friend_list, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx)
            .load(dataList[position].image_url)
            .into(holder.imgthumbnail2)
        holder.temp.text = dataList[position].temp.toString() + "º"
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgthumbnail2 = itemView.findViewById(R.id.rv_item_friend_picture) as CircleImageView
        var temp = itemView.findViewById(R.id.txt_rv_item_friend_name) as TextView

    }
}