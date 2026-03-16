package com.zahra.space.ui.screens.pet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
fun PetHomeScreen(
    onNavigateToDetail: (Long) -> Unit,
    onNavigateToShop: () -> Unit
) {
    var hunger by remember { mutableIntStateOf(50) }
    var happiness by remember { mutableIntStateOf(70) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onNavigateToDetail(1) }
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("🐱", fontSize = 80.sp)
                Text("Si Manis", style = MaterialTheme.typography.headlineSmall)
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text("Lapar: $hunger%")
                Text("Bahagia: $happiness%")
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
            Button(onClick = { }) {
                Text("🧼 Mandi")
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Button(
            onClick = onNavigateToShop,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🛍️ Beli Aksesoris")
        }
    }
}
