package com.example.tipcalculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.ceil


@RunWith(AndroidJUnit4 :: class)
class CalculatorTests {

    @get:Rule
    val activity= ActivityScenarioRule(MainActivity::class.java)

    val tip_percent = 18
    val round_off_switch = false
    val cost = 50.50
    val result = (cost* tip_percent)/100

    @Test
    fun calculate_tip(){
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText(cost.toString()))
            .perform(closeSoftKeyboard())
        var tip_id:Int
        when(tip_percent){
            20 -> tip_id = R.id.option_twenty_percent
            18 -> tip_id = R.id.option_eighteen_percent
            else -> tip_id = R.id.option_fifteen_percent
        }
        onView(withId(tip_id)).perform(click())
        if(!round_off_switch){
            onView(withId(R.id.round_up_switch)).perform(click())
        }
        onView(withId(R.id.calculate)).perform(click())
        if(round_off_switch){
            onView(withId(R.id.tip_result)).check(matches(withText(containsString(ceil(result).toString()))))
        }else{
            onView(withId(R.id.tip_result)).check(matches(withText(containsString(result.toString()))))
        }
    }


}