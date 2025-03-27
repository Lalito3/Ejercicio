package com.example.ejercicio.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio.R
import com.example.ejercicio.viewmodel.EjercicioUiState

//import coil.compose.AsyncImage
//import coil.request.ImageRequest



@Composable
fun HomeScreen(
    ejercicioUiState: EjercicioUiState,
    modifier: Modifier= Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
  // ResultScreen(photos=EjercicioUiState, modifier.padding(top= contentPadding.calculateTopPadding()))

    when(ejercicioUiState){
        is EjercicioUiState.Loading -> LoadingScreen(modifier=modifier.fillMaxSize())
        is EjercicioUiState.Success -> ResultScreen(photos= ejercicioUiState.photo,
            modifier=modifier.fillMaxWidth())
        is EjercicioUiState.Error -> ErrorScreen(modifier=modifier.fillMaxSize())
    }
}
@Composable
fun LoadingScreen(modifier: Modifier=Modifier){
    Box(modifier=modifier,
        contentAlignment =Alignment.Center ){
        Image(painter= painterResource(id= R.drawable.loader),
           contentDescription = "loading" )
    }
}
@Composable
fun ErrorScreen(modifier: Modifier=Modifier){
    Box(modifier=modifier,
        contentAlignment =Alignment.Center ){
        Image(painter= painterResource(id= R.drawable.error_load),
            contentDescription = "Error" )
    }
}

@Composable
fun ResultScreen(photos:String, modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(text = photos )
    }
}
//Nos quedamos en 1:22:28 del video