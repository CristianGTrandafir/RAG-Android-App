package com.example.rentagym;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.navigation.Navigation;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import static java.lang.Thread.sleep;

import com.example.rentagym.Customer.Customer_Chat;
import com.example.rentagym.Seller.SellerActivity;
import com.example.rentagym.Seller.Seller_Chat;
import com.example.rentagym.Seller.Seller_Login;
import com.example.rentagym.Seller.Seller_Register;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//Sometimes the tests return "error performing single click" - upon inspection of stack trace, this is due to emulator lag. Rerun the tests and they should pass.
//Disable animations within the emulator or some tests might fail from executing too quickly.
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    //This launches MainActivity
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    //Test that package name matches
    @Test
    public void PackageNameTest() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.rentagym", appContext.getPackageName());
    }

    //Needed before launching intent, runs before each test
    @Before
    public void setUp() throws Exception{
        Intents.init();
    }

    /************************************ Seller Tests ************************************/

    @Test
    public void Seller_RegisterLaunchTest() {
        //Launches next activity
        onView(withId(R.id.bSeller)).perform(click());
        intended(hasComponent(Seller_Register.class.getName()));
    }

    @Test
    public void Seller_RegisterUsernameButtonTest() {
        //Launches next activity
        onView(withId(R.id.bSeller)).perform(click());
        onView(withId(R.id.seller_username)).perform(typeText("User"), closeSoftKeyboard());
        onView(withId(R.id.seller_username)).check(matches(withText("User")));
    }

    @Test
    public void Seller_RegisterPasswordButtonsTest() {
        //Launches next activity
        onView(withId(R.id.bSeller)).perform(click());
        onView(withId(R.id.seller_password)).perform(typeText("Pword"), closeSoftKeyboard());
        onView(withId(R.id.seller_password)).check(matches(withText("Pword")));
    }

    @Test
    public void Seller_RegisterConfirmPasswordButtonsTest() {
        //Launches next activity
        onView(withId(R.id.bSeller)).perform(click());
        onView(withId(R.id.seller_cpassword)).perform(typeText("Pword"), closeSoftKeyboard());
        onView(withId(R.id.seller_cpassword)).check(matches(withText("Pword")));
    }

    @Test
    public void Seller_RegisterRegistrationTest() {
        //Launches next activity
        onView(withId(R.id.bSeller)).perform(click());
        onView(withId(R.id.seller_password)).perform(typeText("Samplelogin123"), closeSoftKeyboard());
        onView(withId(R.id.seller_cpassword)).perform(typeText("Samplelogin123"), closeSoftKeyboard());
        onView(withId(R.id.seller_username)).perform(typeText("test1@test.com"), closeSoftKeyboard());
        onView(withId(R.id.seller_register)).perform(click());
        //Should stay on same screen
        intended(hasComponent(Seller_Register.class.getName()));
    }

    @Test
    public void Seller_LoginLaunchTest() {
        //Launches next activity
        onView(withId(R.id.bSeller)).perform(click());
        onView(withId(R.id.seller_login)).perform(click());
        intended(hasComponent(Seller_Login.class.getName()));
    }

    @Test
    public void Seller_LoginUsernameButtonTest() {
        //Launches next activity
        onView(withId(R.id.bSeller)).perform(click());
        onView(withId(R.id.seller_login)).perform(click());
        onView(withId(R.id.seller_login_username)).perform(typeText("User"), closeSoftKeyboard());
        onView(withId(R.id.seller_login_username)).check(matches(withText("User")));
    }

    @Test
    public void Seller_LoginPasswordButtonsTest() {
        //Launches next activity
        onView(withId(R.id.bSeller)).perform(click());
        onView(withId(R.id.seller_login)).perform(click());
        onView(withId(R.id.seller_login_password)).perform(typeText("pword"), closeSoftKeyboard());
        onView(withId(R.id.seller_login_password)).check(matches(withText("pword")));
    }

    @Test
    public void Seller_LoginLoginTest() {
        //Launches next activity
        NavigateToSellerActivity();
        //Should go to next screen
        intended(hasComponent(SellerActivity.class.getName()));
    }

    @Test
    public void SellerActivityHomeFragmentTest() {
        NavigateToSellerActivity();
        onView(withId(R.id.CustomerHomeFragment)).check(matches(isDisplayed()));
    }

    @Test
    public void SellerActivityProfileFragmentTest() throws InterruptedException {
        NavigateToSellerActivity();
        sleep(100);
        onView(withId(R.id.profile)).perform(click());
        onView(withId(R.id.profilePicImageView)).check(matches(isDisplayed()));
    }

    @Test
    public void SellerActivityProfileFragmentEdittingTest() throws InterruptedException {
        NavigateToSellerActivity();
        sleep(100);
        onView(withId(R.id.profile)).perform(click());

        onView(withId(R.id.userNameTextView)).perform(typeText("Sample1"), closeSoftKeyboard());
        onView(withId(R.id.userNameTextView)).check(matches(withText("Sample1")));
        onView(withId(R.id.userAddressTextView)).perform(typeText("Sample2"), closeSoftKeyboard());
        onView(withId(R.id.userAddressTextView)).check(matches(withText("Sample2")));
        onView(withId(R.id.userWorkoutsTextView)).perform(typeText("Sample3"), closeSoftKeyboard());
        onView(withId(R.id.userWorkoutsTextView)).check(matches(withText("Sample3")));
    }

    @Test
    public void SellerActivityProfileToHomeTest() {
        NavigateToSellerActivity();
        onView(withId(R.id.profile)).perform(click());
        onView(withId(R.id.home)).perform(click());
        onView(withId(R.id.CustomerHomeFragment)).check(matches(isDisplayed()));
    }

    @Test
    public void Seller_ChatLaunchTest() throws InterruptedException {
        NavigateToSellerActivity();
        sleep(100);
        onView(withId(R.id.goToChat)).perform(click());
        intended(hasComponent(Customer_Chat.class.getName()));
    }

    @Test
    public void Seller_ChatTextTest() throws InterruptedException {
        NavigateToSellerActivity();
        sleep(100);
        onView(withId(R.id.goToChat)).perform(click());
        onView(withId(R.id.textMessage)).perform(typeText("Hello"), closeSoftKeyboard());
        onView(withId(R.id.textMessage)).check(matches(withText("Hello")));
    }

    @Test
    public void Seller_ChatSendTest() throws InterruptedException {
        NavigateToSellerActivity();
        sleep(100);
        onView(withId(R.id.goToChat)).perform(click());
        onView(withId(R.id.textMessage)).perform(typeText("Hello"), closeSoftKeyboard());
        onView(withId(R.id.sendMessage)).perform(click());
        onView(withId(R.id.textMessage)).check(matches(withText("")));
    }

    @Test
    public void Seller_ChatReceiveTest() throws InterruptedException {
        NavigateToSellerActivity();
        sleep(100);
        //hasDescendant will fail if multiple messages are equivalent
        double randomNum = Math.random() * (-10000 - 10000);
        onView(withId(R.id.goToChat)).perform(click());
        onView(withId(R.id.textMessage)).perform(typeText("Hello" + randomNum), closeSoftKeyboard());
        onView(withId(R.id.sendMessage)).perform(click());
        onView(ViewMatchers.withId(R.id.messageList)).perform(RecyclerViewActions.scrollTo(
                hasDescendant(withText("Hello" + randomNum))));
    }

    public void NavigateToSellerActivity() {
        onView(withId(R.id.bSeller)).perform(click());
        onView(withId(R.id.seller_login)).perform(click());
        onView(withId(R.id.seller_login_password)).perform(typeText("Samplelogin123"), closeSoftKeyboard());
        onView(withId(R.id.seller_login_username)).perform(typeText("test1@test.com"), closeSoftKeyboard());
        onView(withId(R.id.seller_login_login)).perform(click());
    }

    /************************************ Seller Tests ************************************/

    //Cleans intents, runs after every test
    @After
    public void tearDown() throws Exception{
        Intents.release();
    }
}