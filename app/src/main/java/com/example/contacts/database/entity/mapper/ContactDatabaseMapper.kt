package com.example.contacts.database.entity.mapper

import com.example.contacts.database.entity.ContactDatabase
import com.example.contacts.domain.model.Contact

fun List<ContactDatabase>.asDomainModels(): List<Contact> {
    return map {
        it.asDomainModel()
    }
}

fun ContactDatabase.asDomainModel(): Contact {
    return Contact(firstName, lastName, phoneNumber, email)
}
