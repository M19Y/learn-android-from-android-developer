package com.m19y.learn.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Wellness(
  @field:StringRes val title: Int,
  @field:StringRes val description: Int,
  @field:DrawableRes val image: Int,
)
