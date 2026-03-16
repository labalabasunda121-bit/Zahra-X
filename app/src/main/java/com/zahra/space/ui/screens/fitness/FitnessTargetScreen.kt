package com.zahra.space.ui.screens.fitness

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FitnessTargetScreen(targetId: Long) {
    var weight by remember { mutableStateOf("62.5") }
    val target = 66.0
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = "Naik Berat 4kg",
                    style = MaterialTheme.typography.headlineSmall
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text("Progress: $weight / $target kg")
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text("Rekomendasi:")
                Text("• Kalori: 2400/hari")
                Text("• Protein: 120g")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Berat Badan (kg)") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Update Berat")
        }
    }
}
