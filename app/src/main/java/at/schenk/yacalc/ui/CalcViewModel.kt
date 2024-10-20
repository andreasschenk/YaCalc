package at.schenk.yacalc.ui

import android.util.Log
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import at.schenk.yacalc.model.Calculator
import at.schenk.yacalc.model.Operator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalcViewModel : ViewModel() {
    private val model: Calculator = Calculator()
    private val _uiState = MutableStateFlow(CalcUiState())
    val uiState: StateFlow<CalcUiState> = _uiState.asStateFlow()
    init {
        resetGame()
    }
    fun resetGame() {
        _uiState.value = CalcUiState()
        model.reset()
    }
    fun clicked(txt:String){
        when{
            txt == "C" -> model.reset()
            txt == "=" -> model.getResult()
            txt.isDigitsOnly() -> model.setDigit(txt.toIntOrNull() ?: 0)
            else -> {model.op = Operator.values().first{it.str == txt}
                        Log.d("calc",model.op.str)
                    }
        }
        val d  = when(model.op){ Operator.NONE -> model.op1.toString(); else -> model.op2.toString();}
        _uiState.update { currentState -> currentState.copy(display = d)}
        Log.d("calc","-->>$txt  ${uiState.value}")
    }
}