package com.example.projetonothungry.adapter


import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeAdapter(activity:AppCompatActivity):FragmentStateAdapter(activity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int) = GalleryHomeFragment.newInstance(position)

}