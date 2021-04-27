package com.jjmorillo.ladespensademicasa.viewModels

import androidx.lifecycle.ViewModel
import com.jjmorillo.ladespensademicasa.application.App
import com.jjmorillo.ladespensademicasa.database.AppDatabase


class TornilloViewModel: ViewModel() {

val db=App.obtenerDB()

}