package com.m19y.learn

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m19y.learn.model.arts
import com.m19y.learn.ui.theme.ArtSpaceTheme

internal fun nextSolutionIndex(current: Int, size: Int): Int =
  (current + 1) % size

internal fun previousSolutionIndex(current: Int, size: Int): Int =
  (current - 1 + size) % size


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ArtSpaceSolutionPreview() {
  ArtSpaceTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      ArtSpaceAppSolution()
    }
  }
}

@Preview(
  name = "Large screen",
  showBackground = true,
  showSystemUi = true,
  device = "spec:width=1280dp,height=800dp,dpi=240"
)
@Composable
private fun ArtSpaceSolutionLargePreview() {
  ArtSpaceTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      ArtSpaceAppSolution()
    }
  }
}

@Composable
fun ArtSpaceAppSolution(modifier: Modifier = Modifier) {
  var currentArt by remember { mutableIntStateOf(0) }
  val art = arts[currentArt]

  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(horizontal = 24.dp, vertical = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Column(
      modifier = Modifier
        .weight(1f)
        .verticalScroll(rememberScrollState()),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      ArtworkWallSolution(
        image = art.image,
        imageDescription = art.imageDescription,
        modifier = Modifier.width(320.dp)
      )

      Spacer(modifier = Modifier.height(16.dp))

      ArtworkDescriptorSolution(
        title = art.title,
        artist = art.artist,
        year = art.year,
        modifier = Modifier.width(320.dp)
      )
    }

    Spacer(modifier = Modifier.height(16.dp))

    DisplayControllerSolution(
      onPrevious = { currentArt = previousSolutionIndex(currentArt, arts.size) },
      onNext = { currentArt = nextSolutionIndex(currentArt, arts.size) },
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp)
    )
  }
}

@Composable
fun ArtworkWallSolution(
  @DrawableRes image: Int,
  @StringRes imageDescription: Int,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier,
    shape = MaterialTheme.shapes.extraSmall,
    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
  ) {
    Image(
      painter = painterResource(image),
      contentDescription = stringResource(imageDescription),
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(3f / 4f)
        .padding(24.dp)
    )
  }
}

@Composable
fun ArtworkDescriptorSolution(
  @StringRes title: Int,
  @StringRes artist: Int,
  year: Int,
  modifier: Modifier = Modifier
) {
  Surface(
    modifier = modifier,
    tonalElevation = 2.dp,
    shape = MaterialTheme.shapes.extraSmall,
    color = MaterialTheme.colorScheme.primaryContainer
  ) {
    Column(modifier = Modifier.padding(12.dp)) {
      Text(
        text = stringResource(title),
        fontSize = 16.sp,
        lineHeight = 22.sp
      )
      Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = stringResource(artist),
          fontWeight = FontWeight.Bold
        )
        Text(text = stringResource(R.string.years, year))
      }
    }
  }
}

@Composable
fun DisplayControllerSolution(
  onPrevious: () -> Unit,
  onNext: () -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Button(
      onClick = onPrevious,
      modifier = Modifier.width(110.dp)
    ) {
      Text(text = "Previous")
    }
    Button(
      onClick = onNext,
      modifier = Modifier.width(110.dp)
    ) {
      Text(text = "Next")
    }
  }
}
