package com.test.api.utils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RandomUtil {
     @Getter
     static String gender="Male";
     @Getter
     static String status= "Active" ;

    public static int getNumber() {
        Random rand = new Random();

        return rand.nextInt(1000);
    }

    public static String getFirstName() {
        return FakerUtil.getFirstName();
    }

    public static String getLastName() {
        return FakerUtil.getLastName();
    }

    public static String getFromDate() {
        return FakerUtil.getFromDate();
    }
    public static String getEmail() {
        return FakerUtil.getEmail();
    }
    public static String getDateToday() {
        return FakerUtil.getToDate();
    }

    public static String getFood() {
        return FakerUtil.getFood();
    }

    public static Boolean getBooleanValueTrue() {

        return FakerUtil.getBooleanValueTrue();
    }

}
