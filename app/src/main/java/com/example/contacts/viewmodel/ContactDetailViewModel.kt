package com.example.contacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contacts.domain.model.Contact

class ContactDetailViewModel(contactModel: Contact) : ViewModel() {

    private val _contact = MutableLiveData<Contact>()
    val contact: LiveData<Contact> get() = _contact

    init {
        _contact.value = contactModel
    }
}
