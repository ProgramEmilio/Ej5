package com.example.ej5.states

import com.example.ej5.models.Book

data class BookState(
    val listaBook: List<Book> = emptyList()
)
