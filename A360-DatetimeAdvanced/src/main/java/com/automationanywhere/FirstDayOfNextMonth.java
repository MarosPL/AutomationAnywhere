package com.automationanywhere;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.DateTimeValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.commandsdk.model.DataType;

import java.time.LocalTime;
import java.time.ZonedDateTime;


import static com.automationanywhere.commandsdk.model.AttributeType.*;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

@BotCommand

//CommandPks adds required information to be dispalable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "DatetimeAdvancedFirstDayOfNextMonth", label = "Get First Day Of Next Month",
        node_label = "Get First Day Of Next Month", description = "Provides with datetime variable with first day of next month", icon = "DateTime.svg",

        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "Assign the output to variable", return_type = DataType.DATETIME, return_required = true)
public class FirstDayOfNextMonth {
    //Messages read from full qualified property file name and provide i18n capability.
    private static final Messages MESSAGES = MessagesFactory
            .getMessages("com.automationanywhere.botcommand.samples.messages");

    //Identify the entry point for the action. Returns a Value<String> because the return type is String.
    @Execute
    public Value<ZonedDateTime> action(
            //Idx 1 would be displayed first, with a text box for entering the value.
            @Idx(index = "1", type = DATETIME)
            //UI labels.
            @Pkg(label = "Source start date and time variable")
            //Ensure that a validation error is thrown when the value is null.
            @NotEmpty
            ZonedDateTime inputDate) {

        ZonedDateTime nextMonth = inputDate.plusMonths(1);
        ZonedDateTime firstDayOfNextMonth = nextMonth.withDayOfMonth(1);
        firstDayOfNextMonth = firstDayOfNextMonth.with(LocalTime.MIN);
        firstDayOfNextMonth = firstDayOfNextMonth.withZoneSameInstant(inputDate.getZone());

        //Return StringValue.
        return new DateTimeValue(firstDayOfNextMonth);
    }
}
