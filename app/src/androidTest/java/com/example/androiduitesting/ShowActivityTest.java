package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.anything;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ShowActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> scenario =
            new ActivityScenarioRule<>(MainActivity.class);

    /** 1️⃣ Test whether the activity correctly switched */
    @Test
    public void testActivitySwitch() {
        // Assume first city is "Edmonton"
        onData(anything()).inAdapterView(withId(R.id.city_list))
                .atPosition(0).perform(click());
        // check if ShowActivity displays
        onView(withId(R.id.city_name_text)).check(matches(isDisplayed()));
    }

    /** 2️⃣ Test whether the city name is consistent */
    @Test
    public void testCityNameDisplayedCorrectly() {
        onData(anything()).inAdapterView(withId(R.id.city_list))
                .atPosition(0).perform(click());
        onView(withId(R.id.city_name_text)).check(matches(withText("Edmonton")));
    }

    /** 3️⃣ Test the back button returns to MainActivity */
    @Test
    public void testBackButton() {
        onData(anything()).inAdapterView(withId(R.id.city_list))
                .atPosition(0).perform(click());
        onView(withId(R.id.back_button)).perform(click());
        // Test go back to main activity
        onView(withId(R.id.city_list)).check(matches(isDisplayed()));
    }
}
