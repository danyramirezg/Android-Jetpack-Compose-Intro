package com.example.androidjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidjetpackcompose.ui.theme.AndroidJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyComplexLayout()
                }
            }
        }
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.TopCenter
        ) {
            Text(text = "Example 4")
        }
        Row(Modifier.fillMaxWidth().weight(1f).background(Color.Magenta)) {
            Box(Modifier.weight(1f).fillMaxHeight().background(Color.Blue), contentAlignment = Alignment.CenterStart){
                Text(text = "Example 2")
            }
            Box(Modifier.fillMaxHeight().weight(1f).background(Color.Magenta), contentAlignment = Alignment.CenterEnd){
                Text(text = "Example 1")
            }
        }
        Box(Modifier.fillMaxWidth().weight(1f).background(Color.Cyan), contentAlignment = Alignment.BottomCenter){
            Text(text = "Example 3")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidJetpackComposeTheme {
        MyComplexLayout()
    }
}