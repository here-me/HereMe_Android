package com.angelhackers.hereme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.angelhackers.hereme.R
import com.angelhackers.hereme.data.FriendListMainData
import com.bumptech.glide.Glide

class FriendListMainAdapter (val ctx : Context, val dataList: ArrayList<FriendListMainData>) : RecyclerView.Adapter<FriendListMainAdapter.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.fragment_main_friend_item, viewGroup, false)
        return  Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx).load(dataList[position].img_url).into(holder.img_thumbnail)
        holder.title.text = dataList[position].title
        holder.num_like.text = "♥"+dataList[position].num_like.toString()
        holder.author.text = dataList[position].author
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var img_thumbnail = itemView.findViewById(R.id.fragment_main_friend_thumbnail) as ImageView
        var title = itemView.findViewById(R.id.fragment_main_friend_title) as TextView
        var num_like = itemView.findViewById(R.id.fragment_main_friend_numlike) as TextView
        var author = itemView.findViewById(R.id.fragment_main_friend_author) as TextView
    }
}