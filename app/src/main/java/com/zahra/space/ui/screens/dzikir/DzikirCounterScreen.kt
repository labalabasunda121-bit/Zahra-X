package com.zahra.space.ui.screens.dzikir

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
fun DzikirCounterScreen(dzikirId: Long) {
    var count by remember { mutableIntStateOf(0) }
    val target = 33
    
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
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = when (dzikirId) {
                        1L -> "سُبْحَانَ اللَّهِ"
                        2L -> "الْحَمْدُ لِلَّهِ"
                        3L -> "اللَّهُ أَكْبَرُ"
                        else -> "اللَّهُ أَكْبَرُ"
                    },
                    fontSize = 32.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Text(
                    text = "$count / $target",
                    fontSize = 48.sp
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { if (count < target) count++ },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Text("TAP", fontSize = 24.sp)
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Button(
            onClick = { count = 0 },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reset")
        }
    }
}
