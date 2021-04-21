package com.jjmorillo.ladespensademicasa.ui.lacteos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jjmorillo.ladespensademicasa.databinding.FragmentLacteosBinding


class LacteosFragment : Fragment() {

private var _binding:FragmentLacteosBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLacteosBinding.inflate(inflater, container, false)
        val view= binding.root
        // Inflate the layout for this fragment
        return view
    }


}