package com.example.ej5

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.ej5.navigation.NavManager
import com.example.ej5.room.BookDatabase
import com.example.ej5.ui.theme.Ej5Theme
import com.example.ej5.viewmodels.BoookViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ej5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val database = Room.databaseBuilder(
                        applicationContext,
                        BookDatabase::class.java,
                        "db_book"
                    ).build()
                    val dao = database.bookDao()

                    val viewModel = BoookViewModel(dao)

                    NavManager(viewModel = viewModel)

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ej5Theme {

    }
}