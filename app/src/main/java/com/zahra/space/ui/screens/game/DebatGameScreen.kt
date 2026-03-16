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
fun DebatGameScreen() {
    var playerHp by remember { mutableIntStateOf(100) }
    var enemyHp by remember { mutableIntStateOf(100) }
    var message by remember { mutableStateOf("Ayo debat!") }
    
    val arguments = listOf(
        Argument("Dalil Quran", 20),
        Argument("Dalil Hadist", 15)
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Debat: Sholat vs Malas", style = MaterialTheme.typography.headlineMedium)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Kamu: $playerHp HP")
            Text("Musuh: $enemyHp HP")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = message,
                modifier = Modifier.padding(24.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        arguments.forEach { arg ->
            Button(
                onClick = {
                    enemyHp = (enemyHp - arg.damage).coerceAtLeast(0)
                    message = "Kamu menggunakan argumen ${arg.name}!"
                    if (enemyHp <= 0) {
                        message = "Kamu menang! +50 poin"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                enabled = playerHp > 0 && enemyHp > 0
            ) {
                Text("${arg.name} (Damage: ${arg.damage})")
            }
        }
    }
}

data class Argument(
    val name: String,
    val damage: Int
)
