package br.com.teste.appturismo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.teste.appturismo.data.TouristSpot
import br.com.teste.appturismo.firebase.fetchTouristSpots

@Composable
fun TouristSpotsListScreen(navController: NavController) {
    val (spots, setSpots) = remember { mutableStateOf<List<TouristSpot>>(emptyList()) }

    // Fetching tourist spots from Firebase
    LaunchedEffect(Unit) {
        fetchTouristSpots { setSpots(it) }
    }

    // Layout da tela
    Column(modifier = Modifier.padding(16.dp)) {
        // Exibir os pontos turísticos em uma LazyColumn
        LazyColumn {
            items(spots) { spot ->
                TouristSpotItem(spot)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para ir à tela de cadastro
        Button(onClick = { navController.navigate("mainS") }) {
            Text("Cadastrar Novo Ponto Turístico")
        }
        // Botão Voltar
        Button(onClick = {navController.popBackStack()}) {
            Text("Voltar")
        }
    }
}