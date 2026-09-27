package com.m19y.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.m19y.learn.data.DataSource
import com.m19y.learn.model.Topic
import com.m19y.learn.ui.theme.GridAppTheme


@Preview
@Composable
private fun TopicItemPrev() {
  GridAppTheme {
    TopicItem(
      Topic(
        R.string.architecture,
        58,
        R.drawable.architecture
      )
    )
  }
}

@Composable
fun TopicItem(topic: Topic, modifier: Modifier = Modifier) {
  val (name, availableCourse, image) = topic
  Card(modifier) {
    Row {
      Box {
        Image(
          painter = painterResource(image),
          contentDescription = stringResource(name),
          modifier = Modifier
            .size(68.dp)
            .aspectRatio(1f),
          contentScale = ContentScale.Crop
        )
      }
      Column {
        Text(
          text = stringResource(name),
          modifier = Modifier.padding(
            start = 16.dp,
            top = 16.dp,
            end = 16.dp,
            bottom = 8.dp
          ),
          style = MaterialTheme.typography.bodyMedium
        )
        Row(
          modifier = Modifier.padding(start = 16.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            painter = painterResource(R.drawable.ic_grain),
            contentDescription = stringResource(R.string.availabel_course)
          )
          Text(
            text = availableCourse.toString(),
            style = MaterialTheme.typography.labelMedium
          )
        }
      }
    }
  }

}

@Preview
@Composable
private fun GridTopicsPrev() {
  GridAppTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      CourseApp(DataSource.topics)
    }
  }
}

@Composable
fun CourseApp(topics: List<Topic>, modifier: Modifier = Modifier) {
  LazyVerticalGrid(
    modifier = modifier,
    columns = GridCells.Fixed(2),
    contentPadding = PaddingValues(start = 8.dp, end = 8.dp, top = 8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    items(items = topics) { topic ->
      TopicItem(topic = topic)
    }
  }
}