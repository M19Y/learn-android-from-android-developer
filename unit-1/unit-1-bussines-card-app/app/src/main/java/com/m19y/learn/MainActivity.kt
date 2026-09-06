package com.m19y.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m19y.learn.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      BusinessCardAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          BusinessCardApp(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
  Box(modifier.background(Color(0xFFD2E8D4))) {
    Profile(modifier = Modifier.align(Alignment.Center))
    ContactInformation(
      modifier = Modifier
        .align(Alignment.BottomCenter)
        .padding(16.dp)
    )
  }
}

@Composable
fun Profile(modifier: Modifier = Modifier) {
  Column(
    modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Image(
      painter = painterResource(R.drawable.android_logo),
      contentDescription = null,
      modifier = Modifier
        .size(100.dp)
        .background(Color(0xFF073042))
    )
    Text(text = stringResource(R.string.full_name), fontSize = 40.sp, modifier = Modifier.padding(top = 8.dp))
    Text(text = stringResource(R.string.title), modifier = Modifier.padding(8.dp))

  }
}

@Composable
fun ContactInformation(modifier: Modifier = Modifier) {
  Column(
    modifier, verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    CardContactInformation(icon = Icons.Default.Phone, text = stringResource(R.string.phone))
    CardContactInformation(icon = Icons.Default.Share, text = stringResource(R.string.social))
    CardContactInformation(icon = Icons.Default.Mail, text = stringResource(R.string.email))
  }
}

@Composable
fun CardContactInformation(
  modifier: Modifier = Modifier,
  icon: ImageVector,
  text: String,
  color: Color = Color(0xFF3ddc84)
) {
  Row(modifier) {
    Icon(imageVector = icon, contentDescription = null, tint = color)
    Spacer(Modifier.width(12.dp))
    Text(text)
  }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
  BusinessCardAppTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      BusinessCardApp()
    }
  }
}