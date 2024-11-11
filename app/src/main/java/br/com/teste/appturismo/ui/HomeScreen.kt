package br.com.teste.appturismo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

        Column(modifier = Modifier.padding(16.dp)) {
            // Barra de pesquisa
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Pesquisar eventos") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Carrossel de eventos
//        EventCarousel()

            Spacer(modifier = Modifier.height(16.dp))

            // Botão para cadastro
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {navController.navigate("cadastro") }

            ){
                Text("Cadastrar-se")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botão para listar Pontos Turisticos
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {navController.navigate("touristSpotsList") }

            ){
                Text("Pontos Turisticos")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botão para login
            Button(
                onClick = {navController.navigate("login") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de GPS para eventos próximos
            Text(text = "Eventos próximos:")
            // Aqui você pode adicionar lógica para obter e mostrar eventos próximos
            Text(text = "Localização: (GPS ou Mapa)", modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
                .clickable { /* Lógica para obter eventos próximos */ }
            )
        }
    }