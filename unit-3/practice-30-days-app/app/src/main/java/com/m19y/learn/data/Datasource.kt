package com.m19y.learn.data

import com.m19y.learn.R
import com.m19y.learn.model.Wellness

class Datasource {
  fun loadWellness(): List<Wellness> {
    return listOf(
      Wellness(R.string.wellness_1_title, R.string.wellness_1_description, R.drawable.borobudur),
      Wellness(R.string.wellness_1_title, R.string.wellness_1_description, R.drawable.borobudur),
      Wellness(R.string.wellness_1_title, R.string.wellness_1_description, R.drawable.borobudur),
      Wellness(R.string.wellness_1_title, R.string.wellness_1_description, R.drawable.borobudur)
    )
  }
}
