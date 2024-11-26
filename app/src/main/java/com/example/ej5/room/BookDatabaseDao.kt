package com.example.ej5.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ej5.models.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDatabaseDao {
    @Insert
    suspend fun agegarBook(book: Book)

    @Query("SELECT * FROM Book")
    fun obtenerBook(): Flow<List<Book>>

    @Update
    suspend fun actualizarBook(book: Book)

    @Delete
    suspend fun borrarBook(book: Book)
}
