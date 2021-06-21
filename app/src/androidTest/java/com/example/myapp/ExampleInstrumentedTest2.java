package com.example.myapp;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest2 {
    @Rule
    public IntentsTestRule<MainActivity_2> activityTestRule =
            new IntentsTestRule<>(MainActivity_2.class);

    @Test
    public void TestStringFill()
    {
        String s1 = "wwwqq1";
        String s2 = "wfgggggggggg\nsssssssss";

        onView(withId(R.id.edittext12)).perform(typeText(s1), closeSoftKeyboard());
        onView(withId(R.id.btnFill)).perform(click());
        onView(withId(R.id.edittext12)).perform(typeText(s2), closeSoftKeyboard());
        onView(withId(R.id.btnFill)).perform(click());

        onView(withId(R.id.txtRes2)).check(matches(withText(s1+"\n"+s2)));
    }


    @Test
    public void TestEditEmpty()
    {
        String s1 = "wwwqq1";

        onView(withId(R.id.edittext12)).perform(typeText(s1), closeSoftKeyboard());
        onView(withId(R.id.btnFill)).perform(click());

        onView(withId(R.id.edittext12)).check(matches(withText("")));
    }




}
