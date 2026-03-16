package com.zahra.space.ui.screens.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zahra.space.ui.theme.IslamicGold
import com.zahra.space.ui.theme.IslamicGreen
import com.zahra.space.ui.theme.IslamicGreenDark
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing)
        )
    )

    LaunchedEffect(Unit) {
        delay(3000)
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(IslamicGreenDark, IslamicGreen)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "ZAHRA SPACE",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .rotate(rotation)
            ) {
                Text(
                    text = "⭐",
                    fontSize = 48.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            
            Spacer(modifier = Modifier.height(48.dp))
            
            Text(
                text = "created by aji",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = IslamicGold
            )
            
            Text(
                text = "for zahra",
                fontSize = 12.sp,
                color = IslamicGold.copy(alpha = 0.8f)
            )
        }
    }
}
