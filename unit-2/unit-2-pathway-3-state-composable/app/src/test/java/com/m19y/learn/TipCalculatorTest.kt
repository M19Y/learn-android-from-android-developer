package com.m19y.learn

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTest {

  @Test
  fun calculateTip_20PercentNoRoundup() {

    val amount: Double = 10.0
    val tipPercent: Double = 20.0
    val expectedTip: String = NumberFormat.getCurrencyInstance().format(2)

    val actualTip = calculateTip(amount, tipPercent, false)
    assertEquals(expectedTip, actualTip)
  }
}