package com.example.ejercicio.ui
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ejercicio.R
import com.example.ejercicio.ui.screens.HomeScreen
import com.example.ejercicio.viewmodel.EjercicioAppViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjercicioApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { EjercicioTopBar(scrollBehavior = scrollBehavior)} //Cambia a comportamiento de scroll
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()) {
            val EjercicioAppViewModel : EjercicioAppViewModel = viewModel()
            HomeScreen(ejercicioUiState = EjercicioAppViewModel.ejercicioUiState, contentPadding= it)

        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjercicioTopBar(scrollBehavior: TopAppBarScrollBehavior,modifier:Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    )
}