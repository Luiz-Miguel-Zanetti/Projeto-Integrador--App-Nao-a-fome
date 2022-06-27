package com.example.projetonothungry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetonothungry.databinding.FragmentGalleryHomeBinding

class GalleryHomeFragment : Fragment() {

    private var binding: FragmentGalleryHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryHomeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding?.root
    }

    companion object {
        var POSITION_ARG = "postion_arg"
        @JvmStatic

        fun newInstance(position:Int) = GalleryHomeFragment().apply {
            arguments = Bundle().apply {
                putInt(POSITION_ARG,position)
            }
        }
    }
}