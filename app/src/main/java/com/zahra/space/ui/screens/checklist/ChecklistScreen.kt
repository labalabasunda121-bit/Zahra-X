package com.zahra.space.ui.screens.checklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChecklistScreen() {
    val checklistItems = remember {
        mutableStateListOf(
            ChecklistItem("Sholat Subuh", false),
            ChecklistItem("Sholat Dzuhur", false),
            ChecklistItem("Sholat Ashar", false),
            ChecklistItem("Sholat Maghrib", false),
            ChecklistItem("Sholat Isya", false),
            ChecklistItem("Dzikir Pagi", false),
            ChecklistItem("Dzikir Petang", false),
            ChecklistItem("Baca Quran", false)
        )
    }
    
    val completedCount = checklistItems.count { it.isChecked }
    val totalItems = checklistItems.size
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Progress Harian")
                Text("$completedCount/$totalItems")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(checklistItems) { item ->
                ChecklistItemRow(item) {
                    val index = checklistItems.indexOf(item)
                    if (index != -1) {
                        checklistItems[index] = item.copy(isChecked = !item.isChecked)
                    }
                }
            }
        }
    }
}

@Composable
fun ChecklistItemRow(item: ChecklistItem, onCheckedChange: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = item.isChecked,
                onCheckedChange = { onCheckedChange() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

data class ChecklistItem(
    val title: String,
    val isChecked: Boolean
)
