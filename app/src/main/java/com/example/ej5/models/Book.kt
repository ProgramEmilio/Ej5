package com.example.ej5.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Book")
data class Book(
        @PrimaryKey(autoGenerate = true) // Asegura que se generen IDs únicos automáticamente
        val id: Int = 0,
        @ColumnInfo("title")
        val title: String,
        @ColumnInfo("author")
        val author: String,
        @ColumnInfo("genre")
        val genre: String,
        @ColumnInfo("price")
        val price: Float,
        @ColumnInfo("pages")
        val pages: Int
)


