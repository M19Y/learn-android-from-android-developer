package com.m19y.learn

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.m19y.learn.ui.theme.StateComposableTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITest {

  @get:Rule
  val composeTestRule: ComposeContentTestRule = createComposeRule()

  @Test
  fun calculate_20_percent_tip() {

    composeTestRule.setContent {
      StateComposableTheme{
        TipTimeLayout()
      }
    }

    composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
    composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")

    val expectedTip = NumberFormat.getCurrencyInstance().format(2)
    composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
      "No node with this text was found."
    )

  }
}