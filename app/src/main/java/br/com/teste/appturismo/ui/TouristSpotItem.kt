package br.com.teste.appturismo.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.teste.appturismo.data.TouristSpot

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TouristSpotItem(spot: TouristSpot) {
    Column {
        Text("Nome: ${spot.nome}")
        Text("Localização: ${spot.localizacao}")
        Text("Descrição: ${spot.descricao}")
        Spacer(modifier = Modifier.height(8.dp))
    }
}