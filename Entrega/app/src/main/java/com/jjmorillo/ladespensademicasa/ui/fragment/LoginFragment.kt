package com.jjmorillo.ladespensademicasa.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private var TAG = "LoginFragment"

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

        binding.mainMbtIniciarSeccion.setOnClickListener {

            NavHostFragment.findNavController(this).navigate(R.id.action_to_productosFragment)
            val email = binding.mainTieUsuario
            val pass1 = binding.mainTiePassword
            auth.signInWithEmailAndPassword(email.obtenerTexto(), pass1.obtenerTexto())
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success")
                            goToProducts()

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d(TAG,  task.exception.toString())
                            Snackbar.make(view, "Error al iniciar sesión", Snackbar.LENGTH_LONG).show()
                        }
                    }


        }
        return view
    }

    /*private fun signIn(email: String, pass1: String){
        Log.d(TAG, "signIn:$email")
        if (!validateFrom()){
            return
        }
    }*/

   /* private fun validateFrom(): Boolean{
        var valid = true

        val email = binding.mainTieUsuario.



    }*/
    fun TextInputEditText.obtenerTexto(): String {
        return text.toString()
    }

    fun goToProducts(){
        val intent = Intent(this.context, ProductosFragment::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

   /* private fun validateForm(): Boolean {
        var valid = true

        val email = binding.fieldEmail.text.toString()
        if (TextUtils.isEmpty(email)) {
            binding.fieldEmail.error = "Required."
            valid = false
        } else {
            binding.fieldEmail.error = null
        }

        val password = binding.fieldPassword.text.toString()
        if (TextUtils.isEmpty(password)) {
            binding.fieldPassword.error = "Required."
            valid = false
        } else {
            binding.fieldPassword.error = null
        }

        return valid
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}