package com.shadowarm.dataclass

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface ContactDao  {
    @Insert
    suspend fun insertContact(contactEntity: ContactEntity)
    @Update
    suspend fun updateContact(contactEntity: ContactEntity)
    @Delete
    suspend fun deleteContact(contactEntity: ContactEntity)
    @Query("Select id,title,price From contact")
    fun getAllContact():LiveData<List<ContactEntity>>
}