package com.zahra.space.ui.screens.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zahra.space.viewmodel.OnboardingViewModel

@Composable
fun OnboardingScreen(
    onComplete: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    var currentStep by remember { mutableIntStateOf(1) }
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var selectedAvatar by remember { mutableStateOf("👩") }
    var selectedPet by remember { mutableStateOf("cat") }
    
    val avatars = listOf("👧", "👩", "🧕")
    val pets = listOf(
        Triple("cat", "🐱 Kucing", "Hewan kesayangan Rasulullah"),
        Triple("rabbit", "🐰 Kelinci", "Cepat dalam kebaikan"),
        Triple("hamster", "🐹 Hamster", "Rajin menyimpan bekal")
    )
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            when (currentStep) {
                1 -> {
                    Text(
                        text = "Assalamu'alaikum! 👋",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Selamat datang di Zahra Space",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                
                2 -> {
                    Text(
                        text = "Lengkapi Profil",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Nama") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    OutlinedTextField(
                        value = age,
                        onValueChange = { age = it },
                        label = { Text("Usia") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text("Pilih Avatar:")
                    Row {
                        avatars.forEach { avatar ->
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                RadioButton(
                                    selected = selectedAvatar == avatar,
                                    onClick = { selectedAvatar = avatar }
                                )
                                Text(avatar, fontSize = 32.sp)
                            }
                        }
                    }
                }
                
                3 -> {
                    Text(
                        text = "Pilih Hewan Virtual",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    pets.forEach { (petId, name, desc) ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            onClick = { selectedPet = petId }
                        ) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = selectedPet == petId,
                                    onClick = { selectedPet = petId }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(name)
                                    Text(desc, style = MaterialTheme.typography.bodySmall)
                                }
                            }
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Row {
                if (currentStep > 1) {
                    Button(
                        onClick = { currentStep-- },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Kembali")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
                
                Button(
                    onClick = {
                        if (currentStep < 3) {
                            currentStep++
                        } else {
                            viewModel.saveUserData(name, age.toIntOrNull() ?: 0, selectedAvatar, selectedPet)
                            onComplete()
                        }
                    },
                    modifier = Modifier.weight(1f),
                    enabled = when (currentStep) {
                        2 -> name.isNotBlank() && age.isNotBlank()
                        else -> true
                    }
                ) {
                    Text(if (currentStep < 3) "Lanjut" else "Selesai")
                }
            }
        }
    }
}
