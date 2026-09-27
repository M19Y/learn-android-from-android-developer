package com.m19y.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.m19y.learn.ui.theme.SuperHeroAppsTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      SuperHeroAppsTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          topBar = { SuperHeroTopAppBar() }) { innerPadding ->
          SuperHeroApp(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}