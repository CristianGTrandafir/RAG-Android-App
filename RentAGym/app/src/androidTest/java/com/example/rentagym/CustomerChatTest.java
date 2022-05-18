package com.example.rentagym;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.rentagym.Customer.CustomerActivity;
import com.example.rentagym.Customer.Customer_Chat;
import com.example.rentagym.Customer.Customer_ChatAI;
import com.example.rentagym.Customer.Customer_Register;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CustomerChatTest {
    private static final String message = "This is a test Message";
    private static final String email = "newUser@gmail.com";
    private static final String password = "password";

    private static final String existUser = "newUser@gmail.com";
    private static final String existPass = "password";

    /*
    Test that the message can be typed.
     */
    @Rule
    public ActivityScenarioRule<MainActivity> ActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);


    @Before
    public void setUp() throws Exception{
        Intents.init();
    }

    @Test
    public void userLaunch(){
        onView(withId(R.id.bCustomer)).perform(click());
        intended(hasComponent(Customer_Register.class.getName()));

    }

    @Test
    public void matchingPasswords(){
        onView(withId(R.id.bCustomer)).perform(click());
        onView(withId(R.id.et_password)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.et_cpassword)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.et_cpassword)).check(matches(withId(R.id.et_password)));

    }

    @Test
    public void validEmail(){
        onView(withId(R.id.bCustomer)).perform(click());
        onView(withId(R.id.et_username)).perform(typeText(email), closeSoftKeyboard());
        onView(withId(R.id.et_username)).check(matches(withText(email)));
    }


    @Test
    public void regTest(){
        onView(withId(R.id.bCustomer)).perform(click());
        onView(withId(R.id.et_username)).perform(typeText(email), closeSoftKeyboard());
        onView(withId(R.id.et_password)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.et_cpassword)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.btn_register)).perform(click());
        intended(hasComponent(Customer_Register.class.getName()));
    }

    @Test
    public void loginTest(){
        onView(withId(R.id.bCustomer)).perform(click());
        onView(withId(R.id.et_lusername)).perform(typeText(email), closeSoftKeyboard());
        onView(withId(R.id.et_lpassword)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.btn_llogin)).perform(click());
        intended(hasComponent(CustomerActivity.class.getName()));
    }

    @Test
    public void validEmailLogin(){
        onView(withId(R.id.bCustomer)).perform(click());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.et_lusername)).perform(typeText(email), closeSoftKeyboard());
        onView(withId(R.id.et_lusername)).check(matches(withText(email)));
    }

    @Test
    public void backToRegister(){
        onView(withId(R.id.bCustomer)).perform(click());
        onView(withId(R.id.btn_lregister)).perform(click());
        intended(hasComponent(Customer_Register.class.getName()));
    }

    @Test
    public void selectItem(){
        navigateToCustomerActivity();
        onData(allOf())
                .inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());

    }

    @Test
    public void getItemInfo(){
        navigateToCustomerActivity();
        onData(allOf())
                .inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.griddata)).check(matches(withText("Treadmills")));

    }
    @Test
    public void getCost(){
        navigateToCustomerActivity();
        onData(allOf())
                .inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.gridprice)).check(matches(withText("$1000")));

    }

    @Test
    public void getSeller(){
        navigateToCustomerActivity();
        onData(allOf())
                .inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.gridsellername)).check(matches(withText("Seller Email: martyg@gmail.com")));

    }

    @Test
    public void getSellerAdd(){
        navigateToCustomerActivity();
        onData(allOf())
                .inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.gridselleraddress)).check(matches(withText("Seller Address: 700 Vine Street, Chicago, IL")));

    }

    @Test
    public void getSellerPhone(){
        navigateToCustomerActivity();
        onData(allOf())
                .inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.gridsellerphone)).check(matches(withText("Mobile Number: 773-738-2933")));
    }

    @Test
    public void enterChat(){
        navigateToCustomerActivity();
        onData(allOf())
                .inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.bCustomerChat)).perform(click());
        intended(hasComponent(Customer_Chat.class.getName()));
    }

    @Test
    public void enterAIChat(){
        navigateToCustomerActivity();
        onData(allOf())
                .inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.bCustomerChatai)).perform(click());
        intended(hasComponent(Customer_ChatAI.class.getName()));
    }

    @Test
    public void enterMessage(){
        navigateToCustomerActivity();
        onData(allOf())
                .inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.bCustomerChat)).perform(click());
        onView(withId(R.id.textMessage)).perform(typeText(message), closeSoftKeyboard());
    }

    @Test
    public void submitMessage(){
        navigateToCustomerActivity();
        onData(allOf())
                .inAdapterView(withId(R.id.gridView))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.bCustomerChat)).perform(click());
        onView(withId(R.id.textMessage)).perform(typeText(message), closeSoftKeyboard());
        onView(withId(R.id.sendMessage)).perform(click());
    }






    public void navigateToCustomerActivity(){
        onView(withId(R.id.bCustomer)).perform(click());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.et_lpassword)).perform(typeText(existPass), closeSoftKeyboard());
        onView(withId(R.id.et_lusername)).perform(typeText(existUser), closeSoftKeyboard());
        onView(withId(R.id.btn_llogin)).perform(click());
    }


    @After
    public void tearDown() throws Exception{
        Intents.release();
    }
}
