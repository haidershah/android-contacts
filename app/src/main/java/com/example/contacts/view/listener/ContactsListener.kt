package com.example.contacts.view.listener

import com.example.contacts.domain.model.Contact

interface ContactsListener {

    fun onContactClicked(contact: Contact)
}
