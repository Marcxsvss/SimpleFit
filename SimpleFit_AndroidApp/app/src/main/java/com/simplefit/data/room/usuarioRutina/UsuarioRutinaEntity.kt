package com.simplefit.data.room.usuarioRutina

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
@Parcelize
@Entity(tableName = "usuariorutina",primaryKeys = ["userid","rutinaid"])
data class UsuarioRutinaEntity(
    @ColumnInfo(name="userid")
    val userid : String,
    @ColumnInfo(name="rutinaid")
    val rutinaid : Int,
    @ColumnInfo(name="nombre")
    val nombre: String
) : Parcelable

