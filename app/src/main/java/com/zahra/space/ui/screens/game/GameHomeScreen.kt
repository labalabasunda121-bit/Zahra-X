package com.zahra.space.ui.screens.game

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameHomeScreen(
    onNavigateToQuiz: () -> Unit,
    onNavigateToCooking: () -> Unit,
    onNavigateToDebat: () -> Unit
) {
    val games = listOf(
        GameItem("Quiz Islam", "📚", onNavigateToQuiz),
        GameItem("Game Masak", "🍳", onNavigateToCooking),
        GameItem("Debat", "🎤", onNavigateToDebat)
    )
    
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(games) { game ->
            GameCard(game)
        }
    }
}

@Composable
fun GameCard(game: GameItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        onClick = game.onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(game.icon, fontSize = 48.sp)
            Text(game.name, style = MaterialTheme.typography.titleMedium)
        }
    }
}

data class GameItem(
    val name: String,
    val icon: String,
    val onClick: () -> Unit
)
