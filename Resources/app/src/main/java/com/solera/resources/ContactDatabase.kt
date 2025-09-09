package com.solera.resources

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contacts::class], version = 1)
public abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao

    //singleton pattern
    companion object {
        @Volatile
        private  var dbInstance: ContactDatabase? = null
        fun getInstance(context: Context): ContactDatabase {
            return dbInstance ?: synchronized(this) {
                dbInstance ?: Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "contacts_db"
                ).build().also { dbInstance = it }
            }
        }
    }

}