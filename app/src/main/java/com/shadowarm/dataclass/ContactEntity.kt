package com.shadowarm.dataclass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class ContactEntity(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val price:String
)
