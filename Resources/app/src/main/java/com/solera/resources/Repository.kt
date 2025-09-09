package com.solera.resources

import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Repository(private val contactDao: ContactDao) {
    fun addContact(contact: Contacts) {
        val executor: ExecutorService = Executors.newSingleThreadExecutor()
        executor.execute {
            contactDao.insert(contact)
        }
    }
    fun deleteContact(contact: Contacts) {
        val executor: ExecutorService = Executors.newSingleThreadExecutor()
        executor.execute {
            contactDao.delete(contact)
        }
    }
    fun getAllContacts(): LiveData<List<Contacts>> {
        return contactDao.getAllContacts()
    }
}