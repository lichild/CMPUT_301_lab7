package com.example.simpleparadox.listycity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.app.Activity;
import android.widget.EditText;
import android.widget.ListView;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {
    private Solo solo;
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class, true, true);

    @Before
    public void setUp(){
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), rule.getActivity());
    }

    @Test
    public void start(){
        Activity activity = rule.getActivity();
    }

    @Test
    public void checkList(){
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("ADD CITY");
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnButton("CONFIRM");
        solo.clearEditText((EditText) solo.getView(R.id.editText_name));


        assertTrue(solo.waitForText("Edmonton", 1,2000));

        solo.clickOnButton("ClEAR ALL");
        assertFalse(solo.searchText("Edmonton"));
    }

    @Test
    public void checkCityListItem(){
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("ADD CITY");
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnButton("CONFIRM");
        solo.clearEditText((EditText) solo.getView(R.id.editText_name));


        assertTrue(solo.waitForText("Edmonton", 1,2000));

        MainActivity mainActivity = (MainActivity) solo.getCurrentActivity();
        final ListView cityList = mainActivity.cityList;
        String city = (String) cityList.getItemAtPosition(0);
        assertEquals("Edmonton", city);
    }

    @Test
    public void showActivityTest(){
        /* add Edmonton */
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("ADD CITY");
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnButton("CONFIRM");
        solo.clearEditText((EditText) solo.getView(R.id.editText_name));


        assertTrue(solo.waitForText("Edmonton", 1,2000));

        solo.clickInList(1);
        solo.assertCurrentActivity("Wrong Activity!", showActivity.class);


        solo.clickOnButton("BACK");
        //solo.goBack();
        assertTrue(solo.searchText("Edmonton"));


        assertTrue(solo.waitForText("Edmonton", 1,2000));

        solo.clickOnButton("ClEAR ALL");
        assertFalse(solo.searchText("Edmonton"));




    }

    @After
    public void tearDown(){
        solo.finishOpenedActivities();
    }
}
