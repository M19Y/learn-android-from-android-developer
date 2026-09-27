package com.m19y.learn.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
  @StringRes val name: Int,
  val availableCourse: Int,
  @DrawableRes val image: Int,
)

