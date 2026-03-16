package com.zahra.space.ui.screens.quran

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuranHafalanScreen(surahId: Int) {
    var userInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Ketik ayat yang dihafal:",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "..........",
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Ketik ayat...") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Button(
            onClick = { 
                result = if (userInput.isNotBlank()) "✅ Benar! +10 poin" else "❌ Masih kosong"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cek Hafalan")
        }
        
        if (result.isNotBlank()) {
            Text(result, modifier = Modifier.padding(8.dp))
        }
    }
}
