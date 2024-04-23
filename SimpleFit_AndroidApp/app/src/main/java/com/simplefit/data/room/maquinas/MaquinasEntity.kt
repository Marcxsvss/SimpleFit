package com.simplefit.data.room.maquinas

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Parcelize
@Entity(tableName = "maquinas")
data class MaquinasEntity(
    @PrimaryKey
    @ColumnInfo(name="maquinaid")
    val maquinaid: Int,
    @ColumnInfo(name="nombre")
    val nombre : String,
    @ColumnInfo(name="musculo")
    val musculo : String,
    @ColumnInfo(name="imagen")//,typeAffinity = ColumnInfo.BLOB)
    val imagen : String?,
    @ColumnInfo(name="descripcion")
    val descripcion: String,
) : Parcelable

