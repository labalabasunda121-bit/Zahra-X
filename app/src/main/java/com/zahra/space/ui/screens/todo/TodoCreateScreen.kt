package com.zahra.space.ui.screens.todo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoCreateScreen(onSave: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var targetDays by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Buat Todo Baru")
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Nama Target") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = targetDays,
            onValueChange = { targetDays = it },
            label = { Text("Target Hari") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = onSave,
            modifier = Modifier.fillMaxWidth(),
            enabled = title.isNotBlank() && targetDays.isNotBlank()
        ) {
            Text("Simpan")
        }
    }
}
