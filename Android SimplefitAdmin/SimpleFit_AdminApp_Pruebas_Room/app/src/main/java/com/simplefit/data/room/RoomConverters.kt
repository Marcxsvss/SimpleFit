package com.pmdm.recetas.data.room

import android.graphics.Bitmap
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pmdm.agenda.utilities.imagenes.Imagenes


class RoomConverters {
    @TypeConverter
    fun toBlob(value: ByteArray?): String? = Imagenes.blobToBase64(value)

    @TypeConverter
    fun fromBlob(value: String?): ByteArray? = Imagenes.base64ToBlob(value)

   @TypeConverter
        fun deListaDeEnterosAString(lista: List<Int>?): String {
            return Gson().toJson(lista)
        }
   @TypeConverter
        fun deStringAListaDeEnteros(cadena: String?): List<Int>? {
            val tipo = object : TypeToken<List<Int>>() {}.type
            return Gson().fromJson(cadena, tipo)
        }
}
