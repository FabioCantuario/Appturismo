package br.com.teste.appturismo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavHostController
import androidx.navigation.compose.*

import br.com.teste.appturismo.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavHost()
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("mainS") {
            MainScreen(navController)
        }
        composable("cadastro") {
            CadastroScreen(navController)
        }
        composable("userList") {
            UserListScreen(navController)
        }
        composable("touristSpotsList") {
            TouristSpotsListScreen(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppNavHost()
}
