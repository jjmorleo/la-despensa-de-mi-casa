package com.jjmorillo.ladespensademicasa.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jjmorillo.ladespensademicasa.R
import com.jjmorillo.ladespensademicasa.application.App
import com.jjmorillo.ladespensademicasa.database.entities.Usuario
import com.jjmorillo.ladespensademicasa.databinding.FragmentRegistroBinding
import com.jjmorillo.ladespensademicasa.viewModels.UsuarioViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RegistroFragment : Fragment() {

    private var _binding: FragmentRegistroBinding? = null
    private val binding: FragmentRegistroBinding
        get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private var TAG = "REGISTRO_FRAGMENT"
    private var db= App.obtenerDB()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        val view = binding.root
        auth = Firebase.auth
        // Inflate the layout for this fragment


        binding.registroBtnRegistrar.setOnClickListener {

            val nombre = binding.registroNameTie
            val email = binding.registroTieUsuario
            val pass1 = binding.registroTiePassword
            val pass2 = binding.registroTieRepitePassword

            if (nombre.obtenerTexto().isNullOrBlank()) {
                Snackbar.make(
                    view,
                    "Revisa los campos, no pueden estar nulos",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (email.obtenerTexto().isNullOrBlank()) {
                Snackbar.make(
                    view,
                    "Revisa los campos, no pueden estar nulos",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (pass1.obtenerTexto().isNullOrBlank()) {
                Snackbar.make(
                    view,
                    "Revisa los campos, no pueden estar nulos",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (pass2.obtenerTexto().isNullOrBlank()) {
                Snackbar.make(
                    view,
                    "Revisa los campos, no pueden estar nulos",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (pass1.obtenerTexto() != pass2.obtenerTexto()) {
                Snackbar.make(view, "¡las contraseñas no coinciden!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
           //LOS DATOS SON CORRECTOS VOY A GUARDAR LOS DATOS EN LA BASE DE DATOS
            val usuarioModel:UsuarioViewModel by viewModels ()//CON ESTA LINEA YA NOS CREA EL OBJETO


            auth.createUserWithEmailAndPassword(email.obtenerTexto(), pass1.obtenerTexto())
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        usuarioModel.save(Usuario(nombre.obtenerTexto(), email.obtenerTexto(), pass1.obtenerTexto(),auth.currentUser.uid))
                        binding.registroBtnRegistrar.setOnClickListener {
                            login(email.obtenerTexto())

                            NavHostFragment.findNavController(this)
                                .navigate(R.id.action_to_loginFragment)
                        }

                    } else {

                        when (task.exception) {
                            is FirebaseAuthWeakPasswordException -> {
                                Snackbar.make(
                                    view,
                                    "la contraseña es muy débil, debe tener 6 caracters",
                                    Snackbar.LENGTH_LONG
                                ).show()
                            }
                            else -> {
                                Snackbar.make(
                                    view,
                                    "No se ha podido registrar el usuario de forma correcta",
                                    Snackbar.LENGTH_LONG
                                ).show()

                            }
                        }
                    }

                }

        }

        binding.registroBtnCancelar.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_to_loginFragment)
        }
        return view
    }

    //ESTO SERIA PARA OBTENER EL TEXTO MAS RAPIDO Y NO TENER QUE HACER EL TEXT.TOSTRING
    fun TextInputEditText.obtenerTexto(): String {
        return text.toString()
    }

    fun login(email: String): LiveData<Usuario> {
        val liveData = MutableLiveData<Usuario>()
        lifecycleScope.launch {//AQUI HACEMOS UNA CONSULTA A LA BASE DE DATOS
            val usuario = withContext(Dispatchers.IO) {
                db.usuarioDao().findOneByEmail(email)

            }
            liveData.postValue(usuario)
        }
        return liveData
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}