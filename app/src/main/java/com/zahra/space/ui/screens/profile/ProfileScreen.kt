package com.zahra.space.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(onNavigateToSettings: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("👩", fontSize = 64.sp, modifier = Modifier.width(80.dp))
                
                Column {
                    Text("Zahra", style = MaterialTheme.typography.headlineSmall)
                    Text("25 tahun", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatCard("Poin", "12.450")
                StatCard("Streak", "12 🔥")
                StatCard("Level", "7")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = onNavigateToSettings,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Pengaturan")
        }
    }
}

@Composable
fun StatCard(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, style = MaterialTheme.typography.titleLarge)
        Text(label, style = MaterialTheme.typography.bodySmall)
    }
}
