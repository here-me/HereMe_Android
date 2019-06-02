package com.angelhackers.hereme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.angelhackers.hereme.R
import com.angelhackers.hereme.data.FriendListMainData
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class FriendListMainAdapter (val ctx : Context, var dataList: ArrayList<FriendListMainData>) : RecyclerView.Adapter<FriendListMainAdapter.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.fragment_main_friend_list, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx)
            .load(dataList[position].image_url)
            .into(holder.img_thumbnail)
        holder.name1.text = dataList[position].name
        holder.name2.text = dataList[position].name
        Glide.with(ctx)
            .load(dataList[position].image_status)
            .into(holder.draw)
        holder.temp.text = dataList[position].temp.toString() + "º"
        holder.rain.text = dataList[position].rain.toString() + "%"
        holder.humidity.text = dataList[position].humi.toString() + "%"
        holder.where.text = dataList[position].locate_name
        holder.where2.text = dataList[position].locate_name
        holder.where3.text = dataList[position].locate_name
        holder.how.text = dataList[position].isGood
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_thumbnail = itemView.findViewById(R.id.rv_item_friend_picture) as CircleImageView

        var name1 = itemView.findViewById(R.id.txt_rv_item_home_friend_name) as TextView
        var name2 = itemView.findViewById(R.id.txt_rv_item_home_friend_name2) as TextView
        var draw = itemView.findViewById(R.id.rv_item_home_friend_draw) as ImageView

        var temp = itemView.findViewById(R.id.txt_rv_item_friend_name) as TextView
        var addFriendBtn = itemView.findViewById(R.id.rv_item_friend_request) as Button

        var rain = itemView.findViewById(R.id.rv_item_home_rain) as TextView
        var humidity = itemView.findViewById(R.id.rv_item_home_friend_humidity) as TextView
        var where = itemView.findViewById(R.id.rv_item_home_friend_where) as TextView
        var where2 = itemView.findViewById(R.id.txt_rv_item_home_friend_where2) as TextView
        var where3 = itemView.findViewById(R.id.txt_rv_item_home_friend_where3) as TextView
        var how = itemView.findViewById(R.id.rv_item_home_friend_how) as TextView
    }
}