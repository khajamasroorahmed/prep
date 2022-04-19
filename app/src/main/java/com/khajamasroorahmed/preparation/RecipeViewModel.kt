package com.khajamasroorahmed.preparation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khajamasroorahmed.network.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
) : ViewModel() {
    sealed class RecipeUiState {
        object Loading: RecipeUiState()
        data class Success(val data: String): RecipeUiState()
        object Error: RecipeUiState()
    }

    private var mutableUiState: MutableStateFlow<RecipeUiState> = MutableStateFlow(RecipeUiState.Loading)
    val uiState: StateFlow<RecipeUiState> = mutableUiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val data = recipeRepository.fetchOrders()
                mutableUiState.emit(RecipeUiState.Success(data.data.keys.fold("") { acc, value -> acc + "$value" }))
            } catch (e: Exception) {
                mutableUiState.emit(RecipeUiState.Error)
            }
        }
    }
}