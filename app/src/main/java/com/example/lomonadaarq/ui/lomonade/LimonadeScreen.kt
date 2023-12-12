package com.example.lomonadaarq.ui.lomonade

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lomonadaarq.R
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LimonadeScreen(viewModel: LimonadeViewModel = viewModel()){
    val limonadeUiState by viewModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ){
        limonade(
            Modifier
                .fillMaxSize()
                .background(Color.Cyan),
            limonadeUiState.img,
            limonadeUiState.textAux,
            limonadeUiState.showText,
            limonadeUiState.auxExp,
            limonadeUiState.exprimido,
            {viewModel.onChange()}
        )
    }

}

@Composable
fun limonade(modifier : Modifier,img:Int,textInfo:Int,show:Boolean,exprimir:Int,exprimido:Int,onChange: () -> Unit,) {
    Column(
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Button(
            onClick = onChange,
            modifier = Modifier.background(Color.Magenta)
        ) {
            Image(
                painter = painterResource(img),
                contentDescription =  null
            )
        }

        Text(
            text = stringResource(textInfo),
            fontFamily = FontFamily.Cursive,
            fontSize = 24.sp,
            color = Color.Yellow
        )
        if(show){
            Text(
                text = stringResource(textInfo) +" "+ exprimido + " : "+ exprimir,
                fontFamily = FontFamily.Cursive,
                fontSize = 24.sp,
                color = Color.Yellow
            )
        }

    }
}
