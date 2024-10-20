package at.schenk.yacalc.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import at.schenk.yacalc.ui.theme.YaCalcTheme


@OptIn(ExperimentalStdlibApi::class)
@Composable
fun YaCalcApp(modifier: Modifier = Modifier, vm : CalcViewModel = viewModel()) {
    val calcUiState by vm.uiState.collectAsState()
    Log.d("calc","-> compo   ${calcUiState.display}")
    Column {
        Text(text = calcUiState.display,
            style = MaterialTheme.typography.displaySmall)
        val arr = arrayOf("1","2","3","+","4","5","6","-","7","8","9","*","0","C","=",":")
        val rows = 4
        val cols = 4
        for (i in 0..<rows)
        Row {
            for (j in 0..<cols)
            CalcButton(txt = arr[i*cols+j], vm = vm)
        }
    }
}

@Composable
fun CalcButton(txt: String, vm: CalcViewModel){
    Button(onClick = { vm.clicked(txt) }) {
        Text(text = txt)
    }
}

@Preview(showBackground = true)
@Composable
fun YaCalcPreview() {
    YaCalcTheme {
        YaCalcApp()
    }
}