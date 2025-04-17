package com.automationanywhere;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestDayOfWeek {

    @Test
    public void TestGetDayOfWeek() {
        ZonedDateTime inputDate = ZonedDateTime.of(2023,4,5,23,00,0,0, ZoneId.systemDefault());

        DayOfWeek dayOfWeek = new DayOfWeek();

        String dayOfWeekString = dayOfWeek.action(inputDate).toString();

        Assert.assertEquals(dayOfWeekString,"WEDNESDAY");
    }
}