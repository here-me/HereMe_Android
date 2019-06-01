package com.angelhackers.hereme.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.angelhackers.hereme.fragment.MainFriendListFragment
import com.angelhackers.hereme.fragment.MainHomeFragment
import com.angelhackers.hereme.fragment.MainSettingFragment

class ProductMainPagerAdapter(fm: FragmentManager, private val num_fragment: Int) : FragmentStatePagerAdapter(fm){
    companion object {
        private var homeMainFragment: MainHomeFragment? = null
        private var friendListMainFragment: MainFriendListFragment? = null
        private var settingMainFragment: MainSettingFragment? = null

        @Synchronized
        fun getMainHomeFragment() : MainHomeFragment{
            if(homeMainFragment == null) homeMainFragment = MainHomeFragment()
            return homeMainFragment!!
        }
        @Synchronized
        fun getMainFriendListFragment() : MainFriendListFragment{
            if(friendListMainFragment == null) friendListMainFragment = MainFriendListFragment()
            return friendListMainFragment!!
        }
        @Synchronized
        fun getMainSettingFragment() : MainSettingFragment{
            if(settingMainFragment == null) settingMainFragment = MainSettingFragment()
            return settingMainFragment!!
        }
    }

    override fun getItem(p0: Int): Fragment? {
        return when(p0){
            0-> getMainHomeFragment()
            1-> getMainFriendListFragment()
            2-> getMainSettingFragment()
            else -> null
        }
    }

    override fun getCount(): Int = num_fragment
}