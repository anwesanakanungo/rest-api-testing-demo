package com.test.api.testcases;

import com.test.api.utils.JsonReader;
import org.testng.annotations.Test;

public class TestCreateBooking {
    @Test
    public void updateBookingByReadingJsonFile() {
        String data = JsonReader.readJsonFileGetAsString("src/main/resources/jsonfile/Resonse.json")
                .replace("fname","CIGINIT")
                .replace("lname","lastname");
        System.out.println(data);

    }
}