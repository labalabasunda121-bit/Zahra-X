package com.zahra.space.ui.screens.todo

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
fun TodoHomeScreen(
    onNavigateToDetail: (Long) -> Unit,
    onNavigateToCreate: () -> Unit
) {
    val todos = remember {
        mutableStateListOf(
            TodoItem(1, "Hafal Juz 30", 20, 30),
            TodoItem(2, "Naik Berat 4kg", 15, 90),
            TodoItem(3, "Baca 10 Buku", 3, 10)
        )
    }
    
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToCreate) {
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
            items(todos) { todo ->
                TodoCard(todo, onNavigateToDetail)
            }
        }
    }
}

@Composable
fun TodoCard(todo: TodoItem, onNavigateToDetail: (Long) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onNavigateToDetail(todo.id) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(todo.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Progress: ${todo.current}/${todo.target} hari")
                Text("${(todo.current * 100 / todo.target)}%")
            }
        }
    }
}

data class TodoItem(
    val id: Long,
    val title: String,
    val current: Int,
    val target: Int
)
