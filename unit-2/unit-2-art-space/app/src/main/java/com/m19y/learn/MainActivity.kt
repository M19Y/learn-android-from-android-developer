package com.m19y.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.m19y.learn.model.Art
import com.m19y.learn.model.arts
import com.m19y.learn.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      ArtSpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//          ArtSpaceApp(modifier = Modifier.padding(innerPadding))
          ArtSpaceAppSolution(modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun ArtSpacePreview() {
  ArtSpaceTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      ArtSpaceApp()
    }
  }
}

@Composable
fun ArtCard(art: Art, modifier: Modifier = Modifier) {
  val (image, imageDescription, title, artist, year) = art

  Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
    ArtworkWall(
      image = image,
      imageDescription = imageDescription,
      modifier = Modifier
        .fillMaxWidth()
        .height(450.dp)
        .padding(horizontal = 16.dp)
    )
    Spacer(Modifier.height(84.dp))
    ArtworkDescriptor(title = title, artist = artist, year = year)
  }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
  var currentArt by remember { mutableIntStateOf(0) }
  var art by remember { mutableStateOf(arts[currentArt]) }

  Box(modifier.fillMaxSize()) {
    ArtCard(art = art, modifier = Modifier.align(Alignment.Center))
    DisplayController(
      modifier = Modifier
        .align(Alignment.BottomCenter)
        .padding(bottom = 16.dp),
      onNext = {
        currentArt = (currentArt + 1) % arts.size
        art = arts[currentArt]
      },
      onPrevious = {
        currentArt = (currentArt - 1 + arts.size) % arts.size
        art = arts[currentArt]
      })
  }
}

@Composable
fun ArtworkWall(
  @DrawableRes image: Int,
  @StringRes imageDescription: Int,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier,
    shape = MaterialTheme.shapes.extraSmall,
    elevation = CardDefaults.elevatedCardElevation(4.dp)
  ) {
    Image(
      painterResource(image),
      contentDescription = stringResource(imageDescription),
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .background(color = Color(0xFFFFFFFF))
        .padding(32.dp)
    )
  }
}

@Composable
fun ArtworkDescriptor(
  @StringRes title: Int,
  @StringRes artist: Int,
  @StringRes year: Int,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .background(MaterialTheme.colorScheme.primaryContainer)
      .padding(16.dp),
  ) {
    Text(text = stringResource(title))
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
      Text(text = stringResource(artist), fontWeight = FontWeight.Bold)
      Text(text = stringResource(R.string.years, year))
    }
  }
}

@Composable
fun DisplayController(
  onNext: () -> Unit,
  onPrevious: () -> Unit,
  modifier: Modifier = Modifier
) {
  Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
    Button(onClick = onPrevious) {
      Text(text = "Previous")
    }
    Button(onClick = onNext) {
      Text(text = "Next")
    }
  }
}