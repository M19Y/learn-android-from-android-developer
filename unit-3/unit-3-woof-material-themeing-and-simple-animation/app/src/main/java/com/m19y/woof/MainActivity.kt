package com.m19y.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.m19y.woof.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      WoofTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          WoofApp(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}