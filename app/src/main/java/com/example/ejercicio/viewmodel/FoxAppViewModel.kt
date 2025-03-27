package com.example.ejercicio.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejercicio.network.EjercicioApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface EjercicioUiState{
    data class Success(val photo:String): EjercicioUiState
    object Error:EjercicioUiState
    object Loading: EjercicioUiState
}

class EjercicioAppViewModel:ViewModel() {
    var ejercicioUiState:EjercicioUiState by  mutableStateOf(EjercicioUiState.Loading)
        private set
    init{
        getEjercicioPhotos()
    }
fun getEjercicioPhotos(){
    viewModelScope.launch{
        ejercicioUiState = try{
            val listResult=EjercicioApi.retrofitService.getPhotos()
            EjercicioUiState.Success(listResult)
            
        } catch(e: IOException){
            EjercicioUiState.Error
            
        }
        //val listResult=EjercicioApi.retrofitService.getPhotos()
        //EjercicioUiState=listResult
    }
}
}