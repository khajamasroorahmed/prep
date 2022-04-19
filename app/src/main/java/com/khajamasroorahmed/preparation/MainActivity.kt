package com.khajamasroorahmed.preparation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import com.khajamasroorahmed.network.RecipeRepository
import com.khajamasroorahmed.preparation.di.AppComponent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {
    private val viewModel: RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val state by viewModel.uiState.collectAsState()

            val text = when (state) {
                    RecipeViewModel.RecipeUiState.Error -> "Error"
                    RecipeViewModel.RecipeUiState.Loading -> "Loading"
                    is RecipeViewModel.RecipeUiState.Success -> (state as RecipeViewModel.RecipeUiState.Success).data
                }
            Text(text = text)
        }
    }
}