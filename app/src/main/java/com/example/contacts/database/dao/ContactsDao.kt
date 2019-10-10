package com.example.contacts.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contacts.database.entity.ContactDatabase
import com.example.contacts.domain.model.Contact

@Dao
interface ContactsDao {

    @Query("SELECT * from contacts_table ORDER BY first_name")
    fun getContacts(): LiveData<List<ContactDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(contact: List<ContactDatabase>)
}
