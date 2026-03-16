package com.zahra.space.ui.screens.pet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun PetShopScreen() {
    val points by remember { mutableIntStateOf(2450) }
    val accessories = listOf(
        Accessory("Peci", 50, "🎩"),
        Accessory("Kacamata", 100, "👓"),
        Accessory("Jubah", 200, "👕"),
        Accessory("Mahkota", 300, "👑")
    )
    
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
                Text("Poin Kamu:")
                Text("$points ✨")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(accessories) { item ->
                AccessoryItem(item, points)
            }
        }
    }
}

@Composable
fun AccessoryItem(item: Accessory, userPoints: Int) {
    val canBuy = userPoints >= item.price
    
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(item.icon, fontSize = 24.sp, modifier = Modifier.width(40.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(item.name)
                Text("${item.price} poin", style = MaterialTheme.typography.bodySmall)
            }
            
            Button(
                onClick = { },
                enabled = canBuy
            ) {
                Text("Beli")
            }
        }
    }
}

data class Accessory(
    val name: String,
    val price: Int,
    val icon: String
)
