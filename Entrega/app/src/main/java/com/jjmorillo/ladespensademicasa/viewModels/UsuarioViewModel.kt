package com.jjmorillo.ladespensademicasa.viewModels


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmorillo.ladespensademicasa.aplication.App
import com.jjmorillo.ladespensademicasa.database.AppDatabase
import com.jjmorillo.ladespensademicasa.database.entities.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioViewModel: ViewModel() {

    val db = App.obtenerDB()

    fun save(usuario: Usuario){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                db.usuarioDao().save(usuario)
            }
        }


    }
fun login(email:String):LiveData<Usuario>{
    val liveData=MutableLiveData<Usuario>()
    viewModelScope.launch {
        val usuario= withContext(Dispatchers.IO){
            db.usuarioDao().findOneByEmail(email)

        }
        liveData.postValue(usuario)
    }
    return liveData
}
}