package com.hotdogcode.notes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Long,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "subtitle")
    var subTitle:String
)
{
    override fun toString(): String {
        return "$id -> $title , $subTitle"
    }
}