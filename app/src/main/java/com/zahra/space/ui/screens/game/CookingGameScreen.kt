package com.zahra.space.ui.screens.game

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CookingGameScreen() {
    var step by remember { mutableIntStateOf(1) }
    var progress by remember { mutableIntStateOf(0) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Game Masak", style = MaterialTheme.typography.headlineMedium)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text("Resep: Nasi Goreng")
                Text("Bahan: Nasi, Telur, Kecap, Bawang")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        when (step) {
            1 -> {
                Text("Langkah 1: Siapkan bahan")
                Button(onClick = { step = 2; progress = 25 }) {
                    Text("Selesai")
                }
            }
            2 -> {
                Text("Langkah 2: Tumis bumbu")
                Button(onClick = { step = 3; progress = 50 }) {
                    Text("Selesai")
                }
            }
            3 -> {
                Text("Langkah 3: Masukkan nasi")
                Button(onClick = { step = 4; progress = 75 }) {
                    Text("Selesai")
                }
            }
            4 -> {
                Text("Langkah 4: Tambah kecap")
                Button(onClick = { step = 5; progress = 100 }) {
                    Text("Selesai")
                }
            }
            5 -> {
                Text("Masakan selesai! +50 poin")
                Button(onClick = { step = 1; progress = 0 }) {
                    Text("Masak Lagi")
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text("Progress: $progress%")
    }
}
