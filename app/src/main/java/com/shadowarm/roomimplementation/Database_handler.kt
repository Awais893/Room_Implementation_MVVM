package com.shadowarm.roomimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shadowarm.Fragment.Delete_fragment
import com.shadowarm.Fragment.UpdateFragment
import com.shadowarm.Fragment.ViewdataFragment
import com.shadowarm.Fragment.addFragment
import com.shadowarm.Repositories.Repository
import com.shadowarm.ViewModels.ContactViewModel
import com.shadowarm.ViewModels.ContactViewModelFactory
import com.shadowarm.dataclass.ContactDatabae
import com.shadowarm.roomimplementation.databinding.ActivityDatabaseHandlerBinding

class Database_handler : AppCompatActivity() {
    lateinit var binding:ActivityDatabaseHandlerBinding
    lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_database_handler)

        val dao=ContactDatabae.getDatabse(applicationContext)
        val repository= Repository(dao)
        contactViewModel=ViewModelProvider(this,ContactViewModelFactory(repository)).get(ContactViewModel::class.java)
        contactViewModel.getAllContact().observe(this, Observer {it
            binding.id=it.toString()
        })
        loadFragment(ViewdataFragment())
        binding.bottomnav.setOnItemSelectedListener {
when(it.itemId)
{
    R.id.addmenu->{
        loadFragment(ViewdataFragment())
true
    }
    R.id.insertmenu->{
        loadFragment(addFragment())
        true
    }
    R.id.updatemenu->{
        loadFragment(UpdateFragment())
        true
    }
    R.id.deletemenu->{
        loadFragment(Delete_fragment())
        true
    }

    else -> {
        false
    }
}

        }

    }
private  fun loadFragment(fragment:Fragment){
val transaction=supportFragmentManager.beginTransaction();
    transaction.replace(R.id.frameLayout,fragment)
    transaction.commit()
}
}