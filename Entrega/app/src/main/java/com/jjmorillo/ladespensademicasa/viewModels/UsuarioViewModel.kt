package com.jjmorillo.ladespensademicasa.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmorillo.ladespensademicasa.application.App
import com.jjmorillo.ladespensademicasa.database.entities.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioViewModel : ViewModel() {

    val db = App.obtenerDB()

    fun save(usuario: Usuario) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.usuarioDao().save(usuario)
            }
        }


    }
//EL val usuario= se realiza para devolver algo de una corutina
    fun login(email: String): LiveData<Usuario> {
        val liveData = MutableLiveData<Usuario>()
        viewModelScope.launch {//AQUI HACEMOS UNA CONSULTA A LA BASE DE DATOS
            val usuario = withContext(Dispatchers.IO) {
                db.usuarioDao().findOneByEmail(email)

            }
            liveData.postValue(usuario)
        }
        return liveData
    }
}