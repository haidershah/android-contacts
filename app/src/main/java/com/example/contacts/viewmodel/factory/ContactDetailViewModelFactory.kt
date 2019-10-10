package com.example.contacts.viewmodel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contacts.domain.model.Contact
import com.example.contacts.viewmodel.ContactDetailViewModel
import java.lang.IllegalArgumentException

class ContactDetailViewModelFactory(
    private val application: Application,
    private val contact: Contact
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactDetailViewModel::class.java)) {
            return ContactDetailViewModel(application, contact) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
