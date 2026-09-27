package com.m19y.learn

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.m19y.learn.data.Datasource
import com.m19y.learn.model.Wellness
import com.m19y.learn.ui.theme._30DaysAppTheme

@Composable
fun Day30Apps(modifier: Modifier) {
  LazyColumn(modifier = modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp)) {
    itemsIndexed(Datasource().loadWellness()) { index, wellness ->
      WellnessCard(
        wellness = wellness,
        day = index + 1,
      )
    }
  }
}

@Composable
fun WellnessCard(
  modifier: Modifier = Modifier,
  wellness: Wellness,
  day: Int = 1,
) {
  val (title, description, image) = wellness
  var expanded by remember { mutableStateOf(false) }
  Card(
    modifier = modifier
      .padding(8.dp)
      .clickable { expanded = !expanded },
    elevation = CardDefaults.elevatedCardElevation(4.dp),
  ) {
    Column(
      modifier = Modifier
        .padding(start = 16.dp, top = 16.dp, end = 16.dp)
        .animateContentSize(
          spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium
          )
        )
    ) {
      Text(
        text = stringResource(R.string.day, day),
        style = MaterialTheme.typography.labelLarge
      )
      Text(
        text = stringResource(title),
        style = MaterialTheme.typography.bodyMedium
      )
      Box(
        modifier
          .height(194.dp)
      ) {
        Image(
          painter = painterResource(image),
          contentDescription = null,
          modifier = Modifier.fillMaxWidth(),
          contentScale = ContentScale.Crop
        )
      }
      if (expanded) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
          text = stringResource(description),
          style = MaterialTheme.typography.bodyMedium
        )
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Wellness30DaysTopAppBar(modifier: Modifier = Modifier) {
  TopAppBar(title = {
    Text(text = stringResource(R.string.app_name))
  }, modifier = modifier)
}

@Preview
@Composable
private fun WellnessCardPrev() {
  _30DaysAppTheme {
    WellnessCard(wellness = Datasource().loadWellness()[0])
  }
}

@Preview
@Composable
private fun Day30AppsPrev() {
  _30DaysAppTheme {
    Scaffold(topBar = { Wellness30DaysTopAppBar() }) {
      Day30Apps(
        modifier = Modifier
          .fillMaxSize()
          .padding(it)
      )
    }
  }
}