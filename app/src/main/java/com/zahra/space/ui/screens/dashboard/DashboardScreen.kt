package com.zahra.space.ui.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zahra.space.viewmodel.DashboardViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DashboardScreen(
    onNavigateToQuran: () -> Unit,
    onNavigateToDzikir: () -> Unit,
    onNavigateToChecklist: () -> Unit,
    onNavigateToTodo: () -> Unit,
    onNavigateToFitness: () -> Unit,
    onNavigateToPet: () -> Unit,
    onNavigateToGame: () -> Unit,
    onNavigateToProfile: () -> Unit,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val userName by viewModel.userName.collectAsState()
    val totalPoints by viewModel.totalPoints.collectAsState()
    val streak by viewModel.streak.collectAsState()
    
    val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale("id"))
    val currentDate = dateFormat.format(Date())
    
    val greeting = when (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
        in 0..10 -> "Selamat Pagi"
        in 11..14 -> "Selamat Siang"
        in 15..17 -> "Selamat Sore"
        else -> "Selamat Malam"
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "$greeting, $userName",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Text(
            text = currentDate,
            style = MaterialTheme.typography.bodyMedium
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem("Poin", "$totalPoints ✨")
                StatItem("Streak", "$streak 🔥")
                StatItem("Progress", "80%")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        val menuItems = listOf(
            MenuItem("Quran", "📖", onNavigateToQuran),
            MenuItem("Dzikir", "📿", onNavigateToDzikir),
            MenuItem("Checklist", "✅", onNavigateToChecklist),
            MenuItem("Todo", "📋", onNavigateToTodo),
            MenuItem("Fitness", "💪", onNavigateToFitness),
            MenuItem("Pet", "🐾", onNavigateToPet),
            MenuItem("Game", "🎮", onNavigateToGame),
            MenuItem("Profil", "👤", onNavigateToProfile)
        )
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(menuItems) { item ->
                MenuCard(item)
            }
        }
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, style = MaterialTheme.typography.titleLarge)
        Text(text = label, style = MaterialTheme.typography.bodySmall)
    }
}

data class MenuItem(val title: String, val icon: String, val onClick: () -> Unit)

@Composable
fun MenuCard(item: MenuItem) {
    Card(
        onClick = item.onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = item.icon, fontSize = 32.sp)
            Text(text = item.title)
        }
    }
}
