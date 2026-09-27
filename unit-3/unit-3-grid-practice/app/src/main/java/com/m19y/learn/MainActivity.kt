package com.m19y.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.m19y.learn.data.DataSource
import com.m19y.learn.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      GridAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          CourseApp(topics = DataSource.topics, modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}