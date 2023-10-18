package br.com.razecapps.samplewithbutton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.razecapps.samplewithbutton.ui.theme.SampleWithButtonTheme

class MainActivity : ComponentActivity() {

    companion object {
        init {
            System.loadLibrary("hello")
        }
    }

    private external fun sayHello(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleWithButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting({ sayHello() })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: () -> String, modifier: Modifier = Modifier) {
    var toggle by remember {
        mutableStateOf(false)
    }
    val fromKotlin: () -> String = {
        "greetings from Kotlin"
    }
    var text by remember {
        mutableStateOf(fromKotlin())
    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Column {
            Text(
                text = text,
                modifier = modifier
            )
            Button( onClick = {
                toggle = !toggle
                text = if (toggle) {
                    name()
                } else {
                    fromKotlin()
                }
            }) {
                Text("Muda")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleWithButtonTheme {
        Greeting({ "Greetings from Kotlin" })
    }
}