package com.example.ej5.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ej5.viewmodels.BoookViewModel
import com.example.ej5.views.AgregarView
import com.example.ej5.views.EditarView
import com.example.ej5.views.InicioView

@Composable
fun NavManager(viewModel: BoookViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio"){
        composable("inicio"){
            InicioView(navController, viewModel)
        }

        composable("agregar"){
            AgregarView(navController, viewModel)
        }

        composable("editar/{id}/{title}/{author}/{price}/{pages}", arguments = listOf(
            navArgument("id"){type = NavType.IntType},
            navArgument("title"){type = NavType.StringType},
            navArgument("author"){type = NavType.StringType},
            navArgument("price"){type = NavType.FloatType},
            navArgument("pages"){type = NavType.IntType}
        )){
            EditarView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("title"),
                it.arguments?.getString("author"),
                it.arguments?.getFloat("price"),
                it.arguments?.getInt("pages")
            )
        }

    }

}