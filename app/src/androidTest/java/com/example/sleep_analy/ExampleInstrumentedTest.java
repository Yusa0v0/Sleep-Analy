package com.example.sleep_analy;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.sleep_analy", appContext.getPackageName());

//        String str = null;
        System.out.println("begin:");

//        try (BufferedReader reader = new BufferedReader(new FileReader("D://sleeping analysis//test.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            FileWriter writer = new FileWriter("D:\\sleeping analysis\\test2.txt");
//            writer.write("Hello, World!");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("filename.txt"));
            writer.write("Hello, World!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}