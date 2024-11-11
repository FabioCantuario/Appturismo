package br.com.teste.appturismo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.teste.appturismo.data.User
import br.com.teste.appturismo.firebase.fetchUser


@Composable
fun UserListScreen(navController: NavController) {
    val (users, setUsers) = remember { mutableStateOf<List<User>>(emptyList()) }

    // Fetching users from Firebase
    LaunchedEffect(Unit) {
        fetchUser { setUsers(it) }
    }

    // Layout da tela
    Column(modifier = Modifier.padding(16.dp)) {
        // Exibir os Usuários em uma LazyColumn
        LazyColumn {
            items(users) { user ->
                UserItem(user)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para ir à tela de cadastro
        Button(onClick = { navController.navigate("cadastro") }) {
            Text("Cadastrar Novo Usuário")
        }
        // Botão Voltar
        Button(onClick = {navController.popBackStack()}) {
            Text("Voltar")
        }
    }
}