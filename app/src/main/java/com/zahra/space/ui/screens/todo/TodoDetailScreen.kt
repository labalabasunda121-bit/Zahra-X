package com.zahra.space.ui.screens.todo

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
fun TodoDetailScreen(todoId: Long) {
    var progress by remember { mutableIntStateOf(15) }
    val target = 30
    
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
                    text = "Hafal Juz 30",
                    style = MaterialTheme.typography.headlineSmall
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text("Progress: $progress / $target hari")
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text("Target harian: 1 halaman")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { if (progress < target) progress++ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Tambah Progress")
        }
    }
}
