package br.com.teste.appturismo.firebase

import android.annotation.SuppressLint
import com.google.firebase.firestore.FirebaseFirestore
import br.com.teste.appturismo.data.TouristSpot
import br.com.teste.appturismo.data.User

// Instância do Firestore
@SuppressLint("StaticFieldLeak")
private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

// Função para buscar pontos turísticos da coleção "tourist_spots"
fun fetchTouristSpots(onResult: (List<TouristSpot>) -> Unit) {
    db.collection("tourist_spots")
        .get()
        .addOnSuccessListener { documents ->
            val spots = documents.mapNotNull { it.toObject(TouristSpot::class.java) }
            onResult(spots)
        }
        .addOnFailureListener { exception ->
            // Tratar erro de acesso ao banco de dados
        }
}

// Função para adicionar um ponto turístico
fun addTouristSpot(nome: String, localizacao: String, descricao: String) {
    val touristSpot = hashMapOf(
        "nome" to nome,
        "localizacao" to localizacao,
        "descricao" to descricao
    )

    db.collection("tourist_spots")
        .add(touristSpot)
        .addOnSuccessListener { documentReference ->
            println("Ponto turístico adicionado com ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            println("Erro ao adicionar ponto turístico: $e")
        }
}
//**************************************************************************************
// Tratamento de Usuario
// Função para buscar Usuarios da coleção "users"
fun fetchUser(onResult: (List<User>) -> Unit) {
    db.collection("users")
        .get()
        .addOnSuccessListener { documents ->
            val users = documents.mapNotNull { it.toObject(User::class.java) }
            onResult(users)
        }
        .addOnFailureListener { exception ->
            // Tratar erro de acesso ao banco de dados
        }
}

// Função para adicionar um Usuario
fun addUser(nome: String, tipo: String, dataNascimento: String, cpf: String, naturalidade: String, email: String, telefone: String, senha: String) {
    val userSpot = hashMapOf(
        "nome" to nome,
        "tipo" to tipo,
        "dataNascimento" to dataNascimento,
        "cpf" to cpf,
        "naturalidade" to naturalidade,
        "email" to email,
        "telefone" to telefone,
        "senha" to senha
    )

    db.collection("users")
        .add(userSpot)
        .addOnSuccessListener { documentReference ->
            println("usuário adicionado com CPF: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            println("Erro ao adicionar Usuario: $e")
        }
}