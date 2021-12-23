package com.example.myapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private MainActivity mainActivity;

    @Before
    public void setExp() throws Exception{
        mainActivity = new MainActivity();
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, mainActivity.sum(2,2));
    }

    @After
    public void memoryClear() throws Exception{
        mainActivity = null;
    }

}