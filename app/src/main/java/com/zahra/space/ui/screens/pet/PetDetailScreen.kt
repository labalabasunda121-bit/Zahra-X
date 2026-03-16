package com.zahra.space.ui.screens.pet

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PetDetailScreen(petId: Long) {
    var hunger by remember { mutableIntStateOf(50) }
    var happiness by remember { mutableIntStateOf(70) }
    var cleanliness by remember { mutableIntStateOf(80) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("🐱", fontSize = 120.sp)
                Text("Si Manis", style = MaterialTheme.typography.headlineMedium)
                Text("Level 3 · Kucing Dewasa")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Status:")
                Text("Lapar: $hunger%")
                Text("Bahagia: $happiness%")
                Text("Kebersihan: $cleanliness%")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { hunger = (hunger - 10).coerceAtLeast(0) }) {
                Text("🍖 Makan")
            }
            Button(onClick = { happiness = (happiness + 10).coerceAtMost(100) }) {
                Text("🎾 Main")
            }
            Button(onClick = { cleanliness = 100 }) {
                Text("🧼 Mandi")
            }
        }
    }
}
