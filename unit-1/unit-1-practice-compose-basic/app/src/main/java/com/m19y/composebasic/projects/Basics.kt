package com.m19y.composebasic.projects

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ComposeArticleApp(modifier: Modifier = Modifier) {
  ComposeArticle(modifier)
}

@Composable
fun ComposeTaskManagerApp(modifier: Modifier = Modifier) {
  TaskManager(modifier)
}

@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier) {
  QuadrantApp(modifier)
}