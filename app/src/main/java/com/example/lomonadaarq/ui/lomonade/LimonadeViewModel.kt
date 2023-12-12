package com.example.lomonadaarq.ui.lomonade

import androidx.lifecycle.ViewModel
import com.example.lomonadaarq.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LimonadeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LimonadeUiState())
    val uiState: StateFlow<LimonadeUiState> = _uiState.asStateFlow()


    fun onChange(){
        var imgAux = _uiState.value.img
        var text = _uiState.value.textAux
        var exprimido = _uiState.value.exprimido
        var aExprimir = _uiState.value.auxExp

        if(imgAux == R.drawable.lemon_tree){
            val exprimir = exprimidor()
            imgAux = R.drawable.lemon_squeeze
            text = R.string.esprimir
            changeEstados(imgAux,text,true,exprimir)

        }else if(imgAux == R.drawable.lemon_squeeze){

            if(exprimido != aExprimir){
                exprimido++
                _uiState.update { currentState -> currentState.copy(
                    exprimido = exprimido
                ) }
            }else{
                //siguiente paso
                imgAux = R.drawable.lemon_drink
                text = R.string.beber
                changeEstados(imgAux,text)
            }

        }else if(imgAux == R.drawable.lemon_drink){

            imgAux = R.drawable.lemon_restart
            text = R.string.repetir
            changeEstados(imgAux,text)

        }else if(imgAux == R.drawable.lemon_restart){

            imgAux = R.drawable.lemon_tree
            text = R.string.coger
            changeEstados(imgAux,text)

        }
    }

    fun changeEstados(imgAux:Int,text:Int, showText:Boolean = false, exprimir:Int = 0, exprimido:Int = 0){
        _uiState.update { currentState -> currentState.copy(
            img = imgAux,
            textAux = text,
            showText = showText,
            auxExp = exprimir,
            exprimido = exprimido
        ) }
    }


    private fun exprimidor(): Int = (1..5).random()

}