package com.automationanywhere;

import com.automationanywhere.Difference;
import com.automationanywhere.botcommand.data.impl.NumberValue;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestDifference {

    @Test
    public void TestDifferenceSeconds(){
        ZonedDateTime startTime = ZonedDateTime.of(2023,4,5,23,00,0,0, ZoneId.systemDefault());
        ZonedDateTime endTime = ZonedDateTime.of(2023,4,6,01,12,2,0,ZoneId.systemDefault());

        Difference datetimeAdvanced = new Difference();

        NumberValue Difference =  datetimeAdvanced.action(startTime,endTime,"Second");
        System.out.println(Difference);

        Assert.assertEquals(Difference.toString(),"7922");
    }
    @Test
    public void TestDifferenceMinutes(){
        ZonedDateTime startTime = ZonedDateTime.of(2023,4,6,01,0,0,0, ZoneId.systemDefault());
        ZonedDateTime endTime = ZonedDateTime.of(2023,4,8,01,5,18,0,ZoneId.systemDefault());

        Difference datetimeAdvanced = new Difference();

        NumberValue Difference =  datetimeAdvanced.action(startTime,endTime,"Minute");
        System.out.println(Difference);

        Assert.assertEquals(Difference.toString(),"2885");
    }
    @Test
    public void TestDifferenceHours(){
        ZonedDateTime startTime = ZonedDateTime.of(2023,4,6,01,0,0,0, ZoneId.systemDefault());
        ZonedDateTime endTime = ZonedDateTime.of(2023,4,8,01,3,3,0,ZoneId.systemDefault());

        Difference datetimeAdvanced = new Difference();

        NumberValue Difference =  datetimeAdvanced.action(startTime,endTime,"Hour");
        System.out.println(Difference);

        Assert.assertEquals(Difference.toString(),"48");
    }

    @Test
    public void TestDifferenceDays(){
        ZonedDateTime startTime = ZonedDateTime.of(2022,4,6,01,0,0,0, ZoneId.systemDefault());
        ZonedDateTime endTime = ZonedDateTime.of(2023,4,8,01,55,33,0,ZoneId.systemDefault());

        Difference datetimeAdvanced = new Difference();

        NumberValue Difference =  datetimeAdvanced.action(startTime,endTime,"Day");
        System.out.println(Difference);

        Assert.assertEquals(Difference.toString(),"367");
    }

    @Test
    public void TestDifferenceMonths(){
        ZonedDateTime startTime = ZonedDateTime.of(2021,3,6,01,0,0,0, ZoneId.systemDefault());
        ZonedDateTime endTime = ZonedDateTime.of(2023,4,8,01,0,0,0,ZoneId.systemDefault());

        Difference datetimeAdvanced = new Difference();

        NumberValue Difference =  datetimeAdvanced.action(startTime,endTime,"Month");
        System.out.println(Difference);

        Assert.assertEquals(Difference.toString(),"25");
    }
}
