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
    @ColumnInfo(name="dni")
    val dni : String,
    @ColumnInfo(name="password")
    val password: String) : Parcelable

