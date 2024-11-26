package com.example.ej5.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ej5.models.Book
import com.example.ej5.viewmodels.BoookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarView (navController: NavController, viewModel: BoookViewModel, id: Int, title: String?, author: String?, price: Float?, pages: Int?){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Editar view", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {navController.popBackStack()}
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                    }
                }
            )
        }
    ){
        ContentEditarView(it, navController, viewModel, id, title, author, price, pages)
    }
}

@Composable
fun ContentEditarView (it: PaddingValues, navController: NavController, viewModel: BoookViewModel, id: Int, title: String?, author: String?, price: Float?, pages: Int?){
    var title by remember { mutableStateOf(title ?: "") }
    var author by remember { mutableStateOf(author ?: "") }
    var price by remember { mutableStateOf(price?.toString() ?: "") }
    var pages by remember { mutableStateOf(pages?.toString() ?: "") }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = title ?: "",
            onValueChange = {title = it},
            label = { Text(text = "Title") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = author ?: "",
            onValueChange = {author = it},
            label = { Text(text = "Author") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = price ?: "",
            onValueChange = {price = it},
            label = { Text(text = "Price") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = pages ?: "",
            onValueChange = {pages = it},
            label = { Text(text = "Pages") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        Button(
            onClick = {
                val priceFloat = price.toFloatOrNull() ?: 0.0f // Convertir String a Float
                val pagesInt = pages.toIntOrNull() ?: 0        // Convertir String a Int

                val book = Book(id = id, title = title!!, author = author!!, price = priceFloat!!, pages = pagesInt!!)

                viewModel.actualizarBook(book)
                navController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }

    }



}