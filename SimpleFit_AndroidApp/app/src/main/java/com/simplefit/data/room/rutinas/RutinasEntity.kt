package com.simplefit.data.room.rutinas

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Parcelize
@Entity(tableName = "rutinas")
data class RutinasEntity(
    @PrimaryKey
    @ColumnInfo(name="rutinaid")
    val rutinaid: Int,
    @ColumnInfo(name="titulo")
    val titulo : String,
    @ColumnInfo(name="descripcion")
    val descripcion : String,
    @ColumnInfo(name="frecuencia")
    val frecuencia : Int
) : Parcelable

