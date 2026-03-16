package com.zahra.space.ui.screens.fitness

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FitnessLogScreen() {
    var calories by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Log Makanan & Olahraga")
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = calories,
            onValueChange = { calories = it },
            label = { Text("Kalori") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simpan")
        }
    }
}
