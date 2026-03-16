package com.zahra.space.ui.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Onboarding : Screen("onboarding")
    data object Dashboard : Screen("dashboard")
    data object Quran : Screen("quran")
    data object Dzikir : Screen("dzikir")
    data object Checklist : Screen("checklist")
    data object Todo : Screen("todo")
    data object Fitness : Screen("fitness")
    data object Pet : Screen("pet")
    data object Game : Screen("game")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
}
