package com.m19y.learn

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m19y.learn.ui.theme.LemonadeTheme

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
  var currentStep by remember { mutableIntStateOf(1) }
  var squeezeCount by remember { mutableIntStateOf(0) }
  var mustTaped by remember { mutableIntStateOf((2..4).random()) }

  Box(modifier.fillMaxSize()) {
    Column(modifier = Modifier.align(Alignment.Center)) {
      when (currentStep) {
        1 -> LemonadeCard(
          onClick = { currentStep = 2 },
          image = R.drawable.lemon_tree,
          imageDescription = R.string.lemon_tree,
          instruction = R.string.tap_the_lemon_tree_to_select_a_lemon
        )

        2 -> LemonadeCard(
          onClick = {
            if (squeezeCount == mustTaped) {
              currentStep = 3
            }
            squeezeCount++
          },
          image = R.drawable.lemon_squeeze,
          imageDescription = R.string.lemon,
          instruction = R.string.keep_tapping_the_lemon_to_squeeze_it,
        )

        3 -> LemonadeCard(
          onClick = { currentStep = 4 },
          image = R.drawable.lemon_drink,
          imageDescription = R.string.glass_of_lemonade,
          instruction = R.string.tap_the_lemonade_to_drink_it,
        )

        4 -> LemonadeCard(
          onClick = {
            currentStep = 1
            squeezeCount = 0
            mustTaped = (2..4).random()
          },
          image = R.drawable.lemon_restart,
          imageDescription = R.string.empty_glass,
          instruction = R.string.tap_the_empty_glass_to_start_again,
        )
      }
    }
  }
}

@Composable
fun LemonadeCard(
  modifier: Modifier = Modifier,
  onClick: () -> Unit,
  @DrawableRes image: Int,
  @StringRes imageDescription: Int,
  @StringRes instruction: Int,
  backgroundImage: Color = Color(0xFFC3ECD2)
) {

  Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {

    Button(
      onClick,
      shape = MaterialTheme.shapes.extraLarge,
      colors = ButtonDefaults.buttonColors(containerColor = backgroundImage),
    ) {
      Image(
        painter = painterResource(image),
        contentDescription = stringResource(imageDescription),
      )
    }

    Spacer(Modifier.height(16.dp))

    Text(
      text = stringResource(instruction),
      fontSize = 18.sp
    )
  }

}

@Preview(showBackground = true)
@Composable
private fun LemonadeAppPrev() {
  LemonadeTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
      LemonadeApp()
    }
  }
}