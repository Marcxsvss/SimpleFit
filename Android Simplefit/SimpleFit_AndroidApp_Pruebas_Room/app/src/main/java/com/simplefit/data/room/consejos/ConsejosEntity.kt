package com.simplefit.data.room.consejos

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Parcelize
@Entity(tableName = "consejos")
data class ConsejosEntity(
    @PrimaryKey
    @ColumnInfo(name="consejoid")
    val consejoid: Int,
    @ColumnInfo(name="consejo")
    val consejo : String

) : Parcelable

