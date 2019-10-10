package com.example.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.contacts.database.dao.ContactsDao
import com.example.contacts.database.entity.ContactDatabase
import com.example.contacts.domain.model.mapper.asDatabaseModels
import com.example.contacts.util.Util
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [ContactDatabase::class], version = 1)
abstract class ContactsDatabase : RoomDatabase() {

    abstract val dao: ContactsDao

    companion object {
        @Volatile
        private lateinit var INSTANCE: ContactsDatabase

        fun getInstance(context: Context): ContactsDatabase {
            synchronized(this) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactsDatabase::class.java,
                        "contacts_database"
                    )
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)

                                CoroutineScope(Dispatchers.IO).launch {
                                    val contacts = Util.contactsFromFile(context)
                                    getInstance(context).dao.insertAll(contacts.asDatabaseModels())
                                }
                            }
                        })
                        .build()
                }
                return INSTANCE
            }
        }
    }
}
