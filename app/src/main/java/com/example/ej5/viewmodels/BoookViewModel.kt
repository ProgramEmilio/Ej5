package com.example.ej5.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ej5.models.Book
import com.example.ej5.room.BookDatabaseDao
import com.example.ej5.states.BookState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BoookViewModel (
    private val dao: BookDatabaseDao
): ViewModel(){
    var state by mutableStateOf(BookState())
        private set

    init {
        viewModelScope.launch {
            dao.obtenerBook().collectLatest {
                state = state.copy(
                    listaBook = it
                )
            }
        }
    }

    fun agregarBook(book: Book) = viewModelScope.launch {
        dao.agegarBook(book = book)
    }

    fun actualizarBook(book: Book) = viewModelScope.launch {
        dao.actualizarBook(book = book)
    }

    fun borrarBook(book: Book) = viewModelScope.launch {
        dao.borrarBook(book = book)
    }
}