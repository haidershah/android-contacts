package com.example.contacts.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contacts.viewmodel.ContactsViewModel
import java.lang.IllegalArgumentException

class ContactsViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactsViewModel::class.java)) {
            return ContactsViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
