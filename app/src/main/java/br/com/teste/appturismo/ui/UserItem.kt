package br.com.teste.appturismo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.teste.appturismo.data.User

@Composable
fun UserItem(user: User) {
    Column{
        Text(text = "Nome: ${user.nome}")
        Text(text = "Tipo: ${user.tipo}")
        Text(text = "Data Nascimento: ${user.dataNascimento}")
        Text(text = "CPF: ${user.cpf}")
        Text(text = "Naturalidade: ${user.naturalidade}")
        Text(text = "E-mail: ${user.email}")
        Text(text = "Telefone: ${user.telefone}")
        Text(text = "Senha: ${user.senha}")
        Spacer(modifier = Modifier.height(8.dp))
    }
}