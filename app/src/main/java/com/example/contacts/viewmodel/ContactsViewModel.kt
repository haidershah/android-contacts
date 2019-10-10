package com.example.contacts.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.contacts.database.ContactsDatabase
import com.example.contacts.domain.model.Contact
import com.example.contacts.repository.ContactsRepository

class ContactsViewModel(context: Context) : ViewModel() {

    private val database = ContactsDatabase.getInstance(context)
    private val repository = ContactsRepository(database)

    val contacts: LiveData<List<Contact>>

    init {
        contacts = repository.getContacts()
    }
}
