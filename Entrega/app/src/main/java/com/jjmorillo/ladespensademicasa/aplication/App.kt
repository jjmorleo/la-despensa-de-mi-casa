package com.jjmorillo.ladespensademicasa.aplication

import android.app.Application
import com.jjmorillo.ladespensademicasa.database.AppDatabase

class App : Application() {

    companion object {

        private var db: AppDatabase? = null

        //AQUI CREAMOS UNA FUNCION DONDE SE DEVUELVE EL APPDATABASE CUANDO HAGA FALTA
        fun obtenerDB(): AppDatabase {

            return db!!

        }

    }

    override fun onCreate() {
        super.onCreate()
        db = AppDatabase.newInstance(applicationContext)//AQUI INICIALIZAMOS EL APPDATABASE
    }

}