package com.example.contacts.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.contacts.database.ContactsDatabase
import com.example.contacts.database.entity.mapper.asDomainModels
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.model.mapper.asDatabaseModel

class ContactsRepository(
    private val database: ContactsDatabase
) {

    fun getContacts(): LiveData<List<Contact>> {
        return Transformations.map(database.dao.getContacts()) {
            it.asDomainModels()
        }
    }

    suspend fun updateContact(contact: Contact) {
        database.dao.update(contact.asDatabaseModel())
    }
}
