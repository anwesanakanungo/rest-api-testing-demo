package com.test.api.testcases;


import com.test.api.utils.JsonReader;
import org.testng.annotations.Test;

public class TestCreateBooking {
    @Test
    public void CreateBookingByReadingJsonFile() {
        String s = JsonReader.readJsonFileGetAsString("src/main/resources/jsonfile/Resonse.json");
        String t=s.replace("fname","new455555555555");
        System.out.println(t);
    }

}