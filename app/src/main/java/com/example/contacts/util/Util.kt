package com.example.contacts.util

import android.content.Context
import com.example.contacts.R
import com.example.contacts.domain.model.Contact
import java.io.BufferedReader
import java.io.InputStreamReader

class Util {
    companion object {
        fun contactsFromFile(context: Context): List<Contact> {
            val contacts = ArrayList<Contact>()

            val inputStream = context.resources.openRawResource(R.raw.contacts_data)
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            var line = bufferedReader.readLine()

            while (line != null) {
                val fields = line.split(",")

                val firstName = fields[0]
                val lastName = fields[1]
                val phoneNumber = fields[fields.size - 2]
                val email = fields[fields.size - 1]

                contacts.add(Contact(firstName, lastName, phoneNumber, email))

                line = bufferedReader.readLine()
            }

            return contacts
        }
    }
}
