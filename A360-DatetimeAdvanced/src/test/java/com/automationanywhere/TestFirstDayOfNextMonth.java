package com.automationanywhere;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestFirstDayOfNextMonth {

    @Test
    public void testAction() {

        ZonedDateTime inputDateTime = ZonedDateTime.of(2023, 5, 8, 15, 30, 0, 0, ZoneId.systemDefault());

        FirstDayOfNextMonth firstDayOfNextMonth = new FirstDayOfNextMonth();

        String firstDayOfNextMonthDate = firstDayOfNextMonth.action(inputDateTime).toString();
        System.out.println(firstDayOfNextMonthDate);

        Assert.assertEquals(firstDayOfNextMonthDate,"2023-06-01T00:00:00+02:00[Europe/Paris]");
    }
}