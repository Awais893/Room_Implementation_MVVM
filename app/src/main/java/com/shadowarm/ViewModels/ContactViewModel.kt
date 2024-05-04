package com.shadowarm.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shadowarm.Repositories.Repository
import com.shadowarm.dataclass.ContactEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: Repository):ViewModel() {

    fun getAllContact():LiveData<List<ContactEntity>>{
        return repository.getAlldata()
    }

     fun insertContact(contactEntity: ContactEntity){
    viewModelScope.launch (Dispatchers.IO){
        repository.insertContact(contactEntity)}
    }
     fun updateContact(contactEntity: ContactEntity){
        viewModelScope.launch(Dispatchers.IO) {
         repository.updateContact(contactEntity)}
    }
     fun deleteContact(contactEntity: ContactEntity){
         viewModelScope.launch(Dispatchers.IO) {
        repository.deleteContact(contactEntity)}
    }


}