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
fun QuizGameScreen() {
    var score by remember { mutableIntStateOf(0) }
    var currentQuestion by remember { mutableIntStateOf(1) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var showResult by remember { mutableStateOf(false) }
    
    val questions = listOf(
        QuizQuestion("Rukun Islam yang pertama?", "Syahadat", "Sholat", "Puasa", "Zakat", "Syahadat"),
        QuizQuestion("Berapa rakaat sholat Subuh?", "2", "3", "4", "1", "2")
    )
    
    val question = questions[currentQuestion - 1]
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Skor: $score", style = MaterialTheme.typography.headlineMedium)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = "Soal $currentQuestion/${questions.size}",
                    style = MaterialTheme.typography.bodyLarge
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = question.question,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        listOf(question.optionA, question.optionB, question.optionC, question.optionD).forEach { option ->
            Button(
                onClick = { 
                    selectedAnswer = option
                    if (option == question.correctAnswer) {
                        score += 10
                    }
                    if (currentQuestion < questions.size) {
                        currentQuestion++
                        selectedAnswer = null
                    } else {
                        showResult = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                enabled = selectedAnswer == null
            ) {
                Text(option)
            }
        }
        
        if (showResult) {
            Text("Game Selesai! Skor akhir: $score")
        }
    }
}

data class QuizQuestion(
    val question: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctAnswer: String
)
