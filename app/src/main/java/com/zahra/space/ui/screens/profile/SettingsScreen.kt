package com.zahra.space.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    var darkMode by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(true) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Pengaturan", style = MaterialTheme.typography.headlineMedium)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Mode Gelap")
                    Switch(
                        checked = darkMode,
                        onCheckedChange = { darkMode = it }
                    )
                }
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Notifikasi")
                    Switch(
                        checked = notifications,
                        onCheckedChange = { notifications = it }
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Backup Data")
        }
        
        Text(
            text = "created by aji for zahra",
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
