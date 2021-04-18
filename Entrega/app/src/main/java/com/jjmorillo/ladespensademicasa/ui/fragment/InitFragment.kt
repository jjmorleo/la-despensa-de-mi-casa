package com.jjmorillo.ladespensademicasa.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.databinding.FragmentInitBinding


class InitFragment : Fragment() {

    private var _binding: FragmentInitBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInitBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        _binding!!.initMaterialButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_to_loginFragment)

        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val sharedPrefs = activity?.getPreferences(Context.MODE_PRIVATE)!!
        val logueado = sharedPrefs.getBoolean("logueado", false)
        if(logueado) {
            NavHostFragment.findNavController(this).navigate(R.id.action_to_productosFragment)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}