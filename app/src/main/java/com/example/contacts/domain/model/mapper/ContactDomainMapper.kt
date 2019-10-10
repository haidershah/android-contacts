package com.example.contacts.domain.model.mapper

import com.example.contacts.database.entity.ContactDatabase
import com.example.contacts.domain.model.Contact

fun Contact.asDatabaseModel(): ContactDatabase {
    return ContactDatabase(
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email
    )
}

fun List<Contact>.asDatabaseModels(): List<ContactDatabase> {
    return map { it.asDatabaseModel() }
}
