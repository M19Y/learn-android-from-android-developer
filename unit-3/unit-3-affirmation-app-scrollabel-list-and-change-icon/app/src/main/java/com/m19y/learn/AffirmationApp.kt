package com.m19y.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.m19y.learn.data.Datasource
import com.m19y.learn.model.Affirmation
import com.m19y.learn.ui.theme.AffirmationsAppTheme

@Preview
@Composable
private fun AffirmationAppPrev() {
  AffirmationsAppTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      AffirmationApp()
    }
  }
}

@Composable
fun AffirmationApp(modifier: Modifier = Modifier) {
  val layoutDirection = LocalLayoutDirection.current
  Surface(
    modifier
      .fillMaxSize()
      .statusBarsPadding()
      .padding(
        start = WindowInsets.safeDrawing.asPaddingValues()
          .calculateStartPadding(layoutDirection),
        end = WindowInsets.safeDrawing.asPaddingValues()
          .calculateEndPadding(layoutDirection)
      )
  ) {
    AffirmationList(Datasource().loadAffirmations())
  }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
  Card(modifier) {
    Column {
      Image(
        painter = painterResource(affirmation.imageResourceId),
        contentDescription = stringResource(affirmation.stringResourceId),
        modifier = Modifier
          .fillMaxWidth()
          .height(194.dp),
        contentScale = ContentScale.Crop
      )
      Text(
        text = stringResource(affirmation.stringResourceId),
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.headlineSmall
      )
    }
  }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
  LazyColumn(modifier = modifier) {
    items(items = affirmationList) { affirmation ->
      AffirmationCard(affirmation, modifier = Modifier.padding(8.dp))
    }
  }
}


