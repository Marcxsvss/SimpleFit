package com.simplefit.data.room.rutinaMaquina

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Parcelize
@Entity(tableName = "rutinamaquina",primaryKeys = ["rutinaid","maquinaid"])
data class RutinaMaquinaEntity(
    @ColumnInfo(name="rutinaid")
    val rutinaid : Int,
    @ColumnInfo(name="maquinaid")
    val maquinaid: Int,
    @ColumnInfo(name="dia")
    val dia : String
) : Parcelable

