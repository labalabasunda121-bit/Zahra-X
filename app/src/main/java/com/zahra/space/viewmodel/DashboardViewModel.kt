package com.zahra.space.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {
    private val _userName = MutableStateFlow("Zahra")
    val userName: StateFlow<String> = _userName
    
    private val _totalPoints = MutableStateFlow(12450L)
    val totalPoints: StateFlow<Long> = _totalPoints
    
    private val _streak = MutableStateFlow(12)
    val streak: StateFlow<Int> = _streak
}
