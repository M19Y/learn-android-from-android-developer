package com.m19y.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

/**
 * Versi orisinal untuk codelab Practice Grid.
 * Sengaja memakai nama berbeda dari CourseApp.kt agar bisa coexist:
 * - [CourseGridScreen] sebagai grid 2 kolom
 * - [TopicGridCard] sebagai kartu tiap topic
 *
 * Cara pakai: di MainActivity ganti
 *   CourseApp(topics = DataSource.topics, ...)
 * menjadi
 *   CourseGridScreen(topics = DataSource.topics, ...)
 */
@Composable
fun TopicGridCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = topic.image),
                contentDescription = stringResource(id = topic.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(id = topic.name),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = stringResource(id = R.string.availabel_course)
                    )
                    Text(
                        text = topic.availableCourse.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun CourseGridScreen(topics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = topics, key = { it.name }) { topic ->
            TopicGridCard(topic = topic)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopicGridCardPreview() {
    GridAppTheme {
        TopicGridCard(
            topic = Topic(
                name = R.string.photography,
                availableCourse = 321,
                image = R.drawable.photography
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CourseGridScreenPreview() {
    GridAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CourseGridScreen(topics = DataSource.topics)
        }
    }
}
