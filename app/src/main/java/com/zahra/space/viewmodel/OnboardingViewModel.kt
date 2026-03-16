package com.zahra.space.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor() : ViewModel() {
    fun saveUserData(name: String, age: Int, avatar: String, petType: String) {
        viewModelScope.launch {
            // Save to repository
        }
    }
}
