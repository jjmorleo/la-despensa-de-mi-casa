package com.jjmorillo.ladespensademicasa.database.converter

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun toDate(date:Long?): Date?{//CUANDO RECUPERAMOS DE LA BASE DE DATOD CONVERTIMOS EL LONG EN DATE
        return date?.let {//--> NO ES NULO
            Date(it)
        }

    }
    @TypeConverter
    fun frontDate(date:Date):Long{//CUANDO QUEREMOS GUARDAR EN LA BD CONVERTIMOS EL DATE EN LONG
        return date.time

    }
}