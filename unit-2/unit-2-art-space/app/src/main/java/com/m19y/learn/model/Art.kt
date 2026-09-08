package com.m19y.learn.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.m19y.learn.R

data class Art(
  @field:DrawableRes val image: Int,
  @field:StringRes val imageDescription: Int,
  @field:StringRes val title: Int,
  @field:StringRes val artist: Int,
  val year: Int
)

val arts: List<Art> = listOf(
  Art(
    R.drawable.pukpik_ab46yumsmp0_unsplash_1_,
    R.string.mount_bromo_indonesia,
    R.string.mount_bromo_indonesia,
    R.string.anonymous,
   2026,
  ),
  Art(
    R.drawable.killian_pham_sq8rpq2kb7u_unsplash_1_,
    R.string.padar_island_indonesia,
    R.string.padar_island_indonesia,
    R.string.anonymous,
    2026,
  ),
  Art(
    R.drawable.snapsaga_wjub3_rbuqg_unsplash_1_,
    R.string.raja_ampat_indonesia,
    R.string.raja_ampat_indonesia,
    R.string.anonymous,
    2026,
  ),
  Art(
    R.drawable.claudia_fernandez_ortiz_tf1qng9ezhq_unsplash_1_,
    R.string.jatiluwih_indonesia,
    R.string.jatiluwih_indonesia,
    R.string.anonymous,
    2026,
  ),
  Art(
    R.drawable.mario_la_pergola_ktha8h_qpow_unsplash_1_,
    R.string.borobudur_indonesia,
    R.string.borobudur_indonesia,
    R.string.anonymous,
    2026,
  ),

)
