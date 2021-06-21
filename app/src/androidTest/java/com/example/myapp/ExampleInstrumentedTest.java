package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Context;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.RootMatchers.isFocusable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.assertEquals;

import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.FailureHandler;
import android.support.test.espresso.NoMatchingRootException;
import android.support.test.espresso.Root;
import android.support.test.espresso.base.DefaultFailureHandler;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import java.util.concurrent.atomic.AtomicReference;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public IntentsTestRule<MainActivity> activityTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void checkPlus()
    {
        int a = 5, b = 4;
        onView(withId(R.id.edittext1)).perform(typeText(String.valueOf(a)), closeSoftKeyboard());
        onView(withId(R.id.edittext2)).perform(typeText(String.valueOf(b)), closeSoftKeyboard());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.txtRes)).check(matches(withText("Результат: 9")));
    }


    
    
    @Test
    public void сheckPlusUnsuccessful()
    {
        onView(withId(R.id.edittext1)).perform(typeText("344456677774"), closeSoftKeyboard());
        onView(withId(R.id.edittext2)).perform(typeText(String.valueOf(4)), closeSoftKeyboard());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.txtRes)).check(matches(withText("Результат: 344456677778")));
    }

    @Test
    public void checkMinus()
    {
        int a = 5, b = 4;
        onView(withId(R.id.edittext1)).perform(typeText(String.valueOf(a)), closeSoftKeyboard());
        onView(withId(R.id.edittext2)).perform(typeText(String.valueOf(b)), closeSoftKeyboard());
        onView(withId(R.id.btnMinus)).perform(click());
        onView(withId(R.id.txtRes)).check(matches(withText("Результат: 1")));
    }

    @Test
    public void checkMultp()
    {
        int a = 5, b = 4;
        onView(withId(R.id.edittext1)).perform(typeText(String.valueOf(a)), closeSoftKeyboard());
        onView(withId(R.id.edittext2)).perform(typeText(String.valueOf(b)), closeSoftKeyboard());
        onView(withId(R.id.btnMult)).perform(click());
        onView(withId(R.id.txtRes)).check(matches(withText("Результат: 20")));
    }

    @Test
    public void checkDel() {
        int a = 5, b = 0;
        onView(withId(R.id.edittext1)).perform(typeText(String.valueOf(a)), closeSoftKeyboard());
        onView(withId(R.id.edittext2)).perform(typeText(String.valueOf(b)), closeSoftKeyboard());
        onView(withId(R.id.btnDel)).perform(click());

        onView(withText(R.string.TOAST_STRING)).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void TestCheckOnSecondActivity()
    {
        onView(withId(R.id.textto2)).perform(click());
        intended(hasComponent(MainActivity_2.class.getName()));
    }




}