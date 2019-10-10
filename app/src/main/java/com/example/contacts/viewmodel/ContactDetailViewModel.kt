package com.example.contacts.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.contacts.database.ContactsDatabase
import com.example.contacts.domain.model.Contact
import com.example.contacts.repository.ContactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ContactDetailViewModel(
    application: Application,
    contactModel: Contact
) : AndroidViewModel(application) {

    private val database = ContactsDatabase.getInstance(getApplication())
    private val repository = ContactsRepository(database)

    private val _contact = MutableLiveData<Contact>()
    val contact: LiveData<Contact> get() = _contact

    init {
        _contact.value = contactModel
    }

    fun saveContact() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                updateContact()
            }
        }
    }

    private suspend fun updateContact() {
        _contact.value?.let {
            repository.updateContact(it)
        }
    }
}
