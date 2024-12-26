package com.example.myapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ui.fragment.ActiveFragment
import com.example.myapplication.ui.fragment.CancelledFragment
import com.example.myapplication.ui.fragment.DeliveredFragment


class TabAdapter (
    fragmentManager: FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle){
    override fun getItemCount(): Int {
        return 3

    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0-> return ActiveFragment()
            1-> return DeliveredFragment()
            2-> return CancelledFragment()
            else-> return ActiveFragment()
        }

    }

}


