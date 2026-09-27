package com.m19y.woof.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
  small = RoundedCornerShape(50.dp),
  medium = RoundedCornerShape(
    topStart = 50.dp,
    topEnd = 0.dp,
    bottomStart = 25.dp,
    bottomEnd = 25.dp
  )
)