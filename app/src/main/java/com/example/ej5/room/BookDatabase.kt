package com.example.ej5.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ej5.models.Book


@Database(entities = [Book::class], version = 2, exportSchema = false) // Incrementa la versión
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDatabaseDao
}
