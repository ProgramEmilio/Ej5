package com.example.ej5.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.ej5.viewmodels.BoookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioView(navController: NavController, viewModel: BoookViewModel){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Inicio view", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate("agregar")},
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ){
        ContentInicioView(it, navController, viewModel)
    }
}

@Composable
fun ContentInicioView(it: PaddingValues, navController: NavController, viewModel: BoookViewModel){
    val state = viewModel.state

    Column (modifier = Modifier.padding(it)){
        LazyColumn {
            items(state.listaBook){
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFF607D8B).copy(alpha = 0.2f), // Azul-gris con transparencia
                            shape = MaterialTheme.shapes.medium // Opcional: redondear esquinas
                        )
                ){
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFf0f0f0), // Color tenue para resaltar el fondo
                                shape = MaterialTheme.shapes.medium // Esquinas redondeadas
                            )
                            .padding(12.dp) // Espaciado interno para que el contenido no quede pegado
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween // Separar columnas
                        ) {
                            // Columna izquierda: Datos del libro
                            Column(
                                modifier = Modifier
                                    .weight(1f) // Distribuir espacio proporcionalmente
                                    .padding(end = 8.dp) // Espacio entre columnas
                            ) {
                                Text(
                                    text = "ID: ${it.id}",
                                    style = MaterialTheme.typography.titleLarge, // Estilo más destacado
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Title: ${it.title}",
                                    style = MaterialTheme.typography.titleMedium, // Estilo más destacado
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Author: ${it.author}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                                Text(
                                    text = "Author: ${it.genre}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                                Text(
                                    text = "Price: $${String.format("%.2f", it.price)}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                                Text(
                                    text = "Pages: ${it.pages} pages",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }

                            // Columna derecha: Botones de acción
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly // Distribuir botones equitativamente
                            ) {
                                IconButton(
                                    onClick = { navController.navigate("editar/${it.id}/${it.title}/${it.author}/${it.genre}/${it.price}/${it.pages}") }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Editar",
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }
                                IconButton(
                                    onClick = { viewModel.borrarBook(it) }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Borrar",
                                        tint = MaterialTheme.colorScheme.error
                                    )
                                }
                            }
                        }
                    }

                }
            }
        }
    }

}