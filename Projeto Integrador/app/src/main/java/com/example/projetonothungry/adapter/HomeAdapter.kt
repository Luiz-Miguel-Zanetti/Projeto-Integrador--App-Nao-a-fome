package com.example.projetonothungry.adapter


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.projetonothungry.GalleryHomeFragment

class HomeAdapter(activity:AppCompatActivity):FragmentStateAdapter(activity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int) = GalleryHomeFragment.newInstance(position)

}