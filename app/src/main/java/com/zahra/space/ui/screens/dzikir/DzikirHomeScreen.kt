package com.zahra.space.ui.screens.dzikir

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DzikirHomeScreen(onNavigateToCounter: (Long) -> Unit) {
    val dzikirList = listOf(
        DzikirItem(1, "Subhanallah", "33x", "Maha Suci Allah"),
        DzikirItem(2, "Alhamdulillah", "33x", "Segala puji bagi Allah"),
        DzikirItem(3, "Allahu Akbar", "33x", "Allah Maha Besar")
    )
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dzikirList) { item ->
            DzikirCard(item, onNavigateToCounter)
        }
    }
}

@Composable
fun DzikirCard(item: DzikirItem, onNavigateToCounter: (Long) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onNavigateToCounter(item.id) }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(item.name, style = MaterialTheme.typography.titleMedium)
                Text(item.description, style = MaterialTheme.typography.bodySmall)
            }
            Text(item.count, style = MaterialTheme.typography.titleLarge)
        }
    }
}

data class DzikirItem(
    val id: Long,
    val name: String,
    val count: String,
    val description: String
)
