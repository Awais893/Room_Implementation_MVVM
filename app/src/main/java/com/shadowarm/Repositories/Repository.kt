package com.shadowarm.Repositories

import androidx.lifecycle.LiveData
import com.shadowarm.dataclass.ContactDao
import com.shadowarm.dataclass.ContactDatabae
import com.shadowarm.dataclass.ContactEntity

class Repository(private val contactDatabae: ContactDatabae){

    //Repository class

    fun getAlldata(): LiveData<List<ContactEntity>> {
        return contactDatabae.contactDao().getAllContact()
    }

    suspend fun insertContact(entity: ContactEntity){
         contactDatabae.contactDao().insertContact(entity)
    }

    suspend fun deleteContact(entity: ContactEntity){
        contactDatabae.contactDao().deleteContact(entity)
    }
    suspend fun updateContact(entity: ContactEntity){
         contactDatabae.contactDao().updateContact(entity)
    }





}