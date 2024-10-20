package at.schenk.yacalc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import at.schenk.yacalc.ui.YaCalcApp
import at.schenk.yacalc.ui.theme.YaCalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("calc","onCreate")
        setContent {
            YaCalcTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    YaCalcApp()
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("calc","onStart")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("calc","onRestart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("calc","onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("calc","onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("calc","onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("calc","onDestroy")
    }
}
