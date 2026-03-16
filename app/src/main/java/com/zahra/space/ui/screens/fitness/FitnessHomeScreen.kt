package com.zahra.space.ui.screens.fitness

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FitnessHomeScreen(
    onNavigateToTarget: (Long) -> Unit,
    onNavigateToLog: () -> Unit
) {
    val targets = remember {
        mutableStateListOf(
            FitnessTarget(1, "Naik Berat 4kg", 62.0, 66.0, 62.5)
        )
    }
    
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToLog) {
                Text("+")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(targets) { target ->
                FitnessTargetCard(target, onNavigateToTarget)
            }
        }
    }
}

@Composable
fun FitnessTargetCard(target: FitnessTarget, onNavigateToTarget: (Long) -> Unit) {
    val progress = ((target.current - target.start) / (target.target - target.start) * 100).toInt()
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onNavigateToTarget(target.id) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(target.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${target.current} / ${target.target} kg")
                Text("$progress%")
            }
        }
    }
}

data class FitnessTarget(
    val id: Long,
    val name: String,
    val start: Double,
    val target: Double,
    val current: Double
)
