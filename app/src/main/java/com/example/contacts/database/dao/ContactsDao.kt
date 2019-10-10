package com.example.contacts.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contacts.database.entity.ContactDatabase

@Dao
interface ContactsDao {

    @Query("SELECT * from contacts_table ORDER BY first_name")
    fun getContacts(): LiveData<List<ContactDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contact: List<ContactDatabase>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(contact: ContactDatabase)
}
