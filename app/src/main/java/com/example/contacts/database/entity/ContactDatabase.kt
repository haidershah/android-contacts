package com.example.contacts.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_table")
data class ContactDatabase(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val firstName: String,

    val lastName: String,

    val phoneNumber: String,

    val email: String
)
