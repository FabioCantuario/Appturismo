//Tela para adicionar e listar os pontos turisticos
package br.com.teste.appturismo.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.teste.appturismo.firebase.addTouristSpot

// Componente principal da tela
@Composable
fun MainScreen(navController: NavController) {
    // Estados para os campos de texto
    var nome by remember { mutableStateOf("") }
    var localizacao by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }

    // Estado para o erro do campo vazio
    var showToast by remember { mutableStateOf(false) }

    // Contexto local para usar o Toast
    val context = LocalContext.current

    // Layout da tela
    Column(modifier = Modifier.padding(16.dp)) {
        // Campos de entrada para um novo ponto turístico
        Text("Nome:")
        BasicTextField(
            value = nome,
            onValueChange = { nome = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Text("Localização:")
        BasicTextField(
            value = localizacao,
            onValueChange = { localizacao = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Text("Descrição:")
        BasicTextField(
            value = descricao,
            onValueChange = { descricao = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para adicionar um novo ponto turístico
        Button(
            onClick = {
                if (nome.isNotEmpty() && localizacao.isNotEmpty() && descricao.isNotEmpty()) {
                    addTouristSpot(nome, localizacao, descricao)
                    // Retorna à tela anterior após adicionar
                    navController.popBackStack()
                } else {
                    // Se algum campo não for preenchido, indica que o Toast deve ser mostrado
                    showToast = true
                }
            }
        ) {
            Text("Adicionar Ponto Turístico")
        }
    }

    // Exibe o Toast caso showToast seja true
    if (showToast) {
        // Exibe o Toast dentro de um LaunchedEffect
        LaunchedEffect(context) {
            Toast.makeText(context, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
        }
        // Reseta o estado após mostrar o Toast
        LaunchedEffect(Unit) {
            showToast = false
        }
    }
}