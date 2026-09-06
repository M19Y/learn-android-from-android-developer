package com.m19y.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.m19y.learn.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      LemonadeTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
          CenterAlignedTopAppBar(
            title = { Text("Lemonade", fontWeight = FontWeight.Bold) },
            colors = TopAppBarDefaults
              .topAppBarColors(containerColor = Color(0xFFFFE501))
          )
        }) { innerPadding ->
          LemonadeApp(Modifier.padding(innerPadding))
        }
      }
    }
  }
}