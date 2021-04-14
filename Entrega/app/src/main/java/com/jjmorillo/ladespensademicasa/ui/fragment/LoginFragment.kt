package com.jjmorillo.ladespensademicasa.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        auth = Firebase.auth
        // Inflate the layout for this fragment

        binding.mainMbtRegistro.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_to_registroFragment)
        }
        return view
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}