package com.pmdm.tienda.data.room.cliente

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.pmdm.recetas.data.room.RoomConverters
import kotlinx.parcelize.Parcelize
@Parcelize
@Entity(tableName = "usuarios")
data class UsuarioEntity(
    @PrimaryKey
    @ColumnInfo(name="email")
    val email: String,
    @ColumnInfo(name="password")
    val password: String,
    @ColumnInfo(name="nombre")
    val nombre : String,
    @ColumnInfo(name="altura")
    val altura : String,
    @ColumnInfo(name="peso")
    val peso : String,
    @ColumnInfo(name="edad")
    val edad : String,
    @ColumnInfo(name="sexo")
    val sexo : String,
    @ColumnInfo(name="somatotipo")
    val somatotipo : String,
    @ColumnInfo(name="rutinaState")
    val rutinaState : Int?,
    @ColumnInfo(name="acceso")
    val cargo : Int
) : Parcelable

