package com.jenkinsunittest;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SignInActivityEspressoTest {

    @Rule
    public ActivityTestRule<SignInActivity> mActivityTestRule = new ActivityTestRule<>(SignInActivity.class);

    @Test
    public void signInActivityEspressoTest() {
        ViewInteraction appCompatEditText = onView(allOf(withId(R.id.user_gmail_et), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(allOf(withId(R.id.user_gmail_et), isDisplayed()));
        appCompatEditText2.perform(replaceText("ramesh.kvana@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(allOf(withId(R.id.user_password_et), isDisplayed()));
        appCompatEditText3.perform(replaceText("123456"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.sign_in_btn), withText("SIGN IN"), isDisplayed()));
        appCompatButton.perform(click());
    }
}
