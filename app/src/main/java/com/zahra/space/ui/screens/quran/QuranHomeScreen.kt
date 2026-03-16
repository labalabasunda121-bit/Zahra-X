package com.zahra.space.ui.screens.quran

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuranHomeScreen(
    onNavigateToRead: (Int, Int) -> Unit,
    onNavigateToHafalan: (Int) -> Unit
) {
    val surahList = (1..10).map { 
        SurahInfo(it, "Surah $it", it / 3 + 1) 
    }
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(surahList.size) { index ->
            val surah = surahList[index]
            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onNavigateToRead(surah.id, 1) }
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("${surah.id}. ${surah.name}")
                    Text("Juz ${surah.juz}")
                }
            }
        }
    }
}

data class SurahInfo(
    val id: Int,
    val name: String,
    val juz: Int
)
