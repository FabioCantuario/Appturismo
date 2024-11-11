package br.com.teste.appturismo.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.teste.appturismo.firebase.addUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(navController: NavController) {

    var nome by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }
    var dataNascimento by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var naturalidade by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    // Estado para o erro do campo vazio
    var showToast by remember { mutableStateOf(false) }

    // Contexto local para usar o Toast
    val context = LocalContext.current

    // Layout da tela
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Cadastro de Usuário") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // Campos de entrada para um novo Usuário
            Text("Nome:")
            BasicTextField(
                value = nome,
                onValueChange = { nome = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Tipo:")
            BasicTextField(
                value = tipo,
                onValueChange = { tipo = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Data Nascimento:")
            BasicTextField(
                value = dataNascimento,
                onValueChange = { dataNascimento = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("CPF:")
            BasicTextField(
                value = cpf,
                onValueChange = { cpf = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Naturalidade:")
            BasicTextField(
                value = naturalidade,
                onValueChange = { naturalidade = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("E-mail:")
            BasicTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Telefone:")
            BasicTextField(
                value = telefone,
                onValueChange = { telefone = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Senha:")
            BasicTextField(
                value = senha,
                onValueChange = { senha = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Botão para adicionar um novo ponto turístico
            Button(
                onClick = {
                    if (nome.isNotEmpty() && tipo.isNotEmpty() && dataNascimento.isNotEmpty() &&
                        cpf.isNotEmpty() && naturalidade.isNotEmpty() && email.isNotEmpty() &&
                        telefone.isNotEmpty() && senha.isNotEmpty()
                    ) {
                        addUser(
                            nome,
                            tipo,
                            dataNascimento,
                            cpf,
                            naturalidade,
                            email,
                            telefone,
                            senha
                        )
                        // Exibe o Toast dentro de um LaunchedEffect
                        Toast.makeText(context, "Usuário Cadastrado com sucesso!!!.", Toast.LENGTH_SHORT)
                                .show()

                        // Limpa os campos de entrada após o sucesso
                        nome = ""
                        tipo = ""
                        dataNascimento = ""
                        cpf = ""
                        naturalidade = ""
                        email = ""
                        telefone = ""
                        senha = ""

                    } else {
                        // Se algum campo não for preenchido, indica que o Toast deve ser mostrado
                        showToast = true
                    }
                }

            ) {
                Text("Adicionar Usuários")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("userList") },
            ) {
                Text("Listar Usuários")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("login") },
            ) {
                Text("Login")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {// Retorna à tela anterior após adicionar
                    navController.popBackStack()}
            ) {
                Text("Voltar")
            }
        }

        // Exibe o Toast caso showToast seja true
        if (showToast) {
            // Exibe o Toast dentro de um LaunchedEffect
            LaunchedEffect(context) {
                Toast.makeText(context, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT)
                    .show()
            }
            // Reseta o estado após mostrar o Toast
            LaunchedEffect(Unit) {
                showToast = false
            }
        }
    }
}