package com.jjmorillo.ladespensademicasa.ui.carnes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jjmorillo.ladespensademicasa.databinding.FragmentCarnesBinding



class CarnesFragment: Fragment() {

    private var _binding: FragmentCarnesBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentCarnesBinding.inflate(inflater, container, false)
        val view= binding.root
        // Inflate the layout for this fragment
        return view
    }


}