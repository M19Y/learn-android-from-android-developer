package com.m19y.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.m19y.learn.datasource.HeroesRepository.heroes
import com.m19y.learn.model.Hero
import com.m19y.learn.ui.theme.SuperHeroAppsTheme

@Composable
fun SuperHeroApp(modifier: Modifier = Modifier) {
  LazyColumn(modifier = modifier) {
    items(heroes) {
      SuperHeroItem(
        hero = it,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
      )
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroTopAppBar(modifier: Modifier = Modifier) {
  CenterAlignedTopAppBar(title = {
    Text(
      text = stringResource(R.string.app_name),
      style = MaterialTheme.typography.displayLarge
    )
  }, modifier = modifier)
}

@Composable
fun SuperHeroItem(hero: Hero, modifier: Modifier = Modifier) {
  val (name, description, image) = hero
  Card(
    modifier = modifier,
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    shape = MaterialTheme.shapes.medium
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .sizeIn(minHeight = 72.dp)
    ) {
      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = stringResource(name),
          style = MaterialTheme.typography.displaySmall
        )
        Text(
          text = stringResource(description),
          style = MaterialTheme.typography.bodyLarge
        )
      }
      Spacer(Modifier.width(16.dp))
      Box(
        modifier = Modifier
          .size(72.dp)
          .clip(MaterialTheme.shapes.small)
      ) {
        Image(
          painter = painterResource(image),
          contentDescription = null,
          alignment = Alignment.TopCenter,
          contentScale = ContentScale.FillWidth
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun SuperHeroItemPrev() {
  SuperHeroAppsTheme {
    SuperHeroItem(heroes[0])
  }
}

@Preview
@Composable
private fun SuperHeroAppPrev() {
  SuperHeroAppsTheme {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = { SuperHeroTopAppBar() }) {
      SuperHeroApp(modifier = Modifier.padding(it))
    }
  }
}