package com.jjmorillo.ladespensademicasa.ui.fragment

import android.content.Context
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
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.databinding.FragmentLoginBinding
import com.jjmorillo.ladespensademicasa.ui.activities.MainActivity
import com.jjmorillo.ladespensademicasa.ui.activities.NavigationDrawer

enum class ProviderType{
    BASIC
}
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private lateinit var auth: FirebaseAuth
    private var TAG = "LoginFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val binding  = _binding!!
        val view = binding.root

        auth = Firebase.auth
        // Inflate the layout for this fragment

        binding.mainMbtRegistro.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_to_registroFragment)
        }


        binding.mainMbtIniciarSeccion.setOnClickListener {

            val email = binding.mainTieUsuario
            val pass1 = binding.mainTiePassword
            if (email.obtenerTexto().isNullOrBlank()) {

                Snackbar.make(
                    view,
                    "Si el email no es correcto o esta vacio rellene el campo ",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            if (pass1.obtenerTexto().isNullOrBlank()) {

                Snackbar.make(
                    view,
                    "Si la contraseña no es correcta o esta vacia rellene el campo ",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener

            }

            val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)!!
            with(sharedPref.edit()) {
                putBoolean("logueado", true)
                apply()
            }
            //NavHostFragment.findNavController(this).navigate(R.id.action_to_mobile_navigation)


            auth.signInWithEmailAndPassword(email.obtenerTexto(), pass1.obtenerTexto())
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        //Log.d(TAG, "signInWithEmail:success")
                        goToProducts()

                    } else {
                        Log.d(TAG, task.exception.toString())
                        when (task.exception) {

                            is FirebaseAuthInvalidUserException -> {

                                Snackbar.make(
                                    view,
                                    "Debes registrarte para acceder",
                                    Snackbar.LENGTH_LONG
                                ).show()
                            }
                            else -> {


                                Snackbar.make(view, "Error al iniciar sesión", Snackbar.LENGTH_LONG)
                                    .show()
                            }

                        }


                        // If sign in fails, display a message to the user.


                    }
                }


        }
        return view
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            goToProducts()
        }
    }

    //PARA CERRAR SESION SERIA COMO SE MUESTRA ACONTINUACION

    /* binding.cerraSesion.setOnClickListener{
         auth.signOut()
         requireActivity().finish()
     }*/
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

    fun goToProducts() {

        _binding!!.mainMbtIniciarSeccion.setOnClickListener {
            //NavHostFragment.findNavController(this).navigate(R.id.action_to_productosFragment)
            val intent= Intent(requireContext(), NavigationDrawer::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        /*val intent = Intent(this.context, ProductosFragment::class.java)
        startActivity(intent)
        requireActivity().finish()*/
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