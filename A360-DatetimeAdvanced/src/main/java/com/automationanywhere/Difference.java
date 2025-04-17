package com.automationanywhere;

import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;

import java.time.ZonedDateTime;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


import static com.automationanywhere.commandsdk.model.AttributeType.*;
import static com.automationanywhere.commandsdk.model.DataType.NUMBER;

@BotCommand

//CommandPks adds required information to be dispalable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "DatetimeAdvancedDifference", label = "Difference",
        node_label = "Difference", description = "Calculate Datetime difference from 2 dates", icon = "DateTime.svg",

        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "Assign the output to variable", return_type = NUMBER, return_required = true)
public class Difference {
    //Messages read from full qualified property file name and provide i18n capability.
    private static final Messages MESSAGES = MessagesFactory
            .getMessages("com.automationanywhere.botcommand.samples.messages");

    //Identify the entry point for the action. Returns a Value<String> because the return type is String.
    @Execute
    public NumberValue action(
            //Idx 1 would be displayed first, with a text box for entering the value.
            @Idx(index = "1", type = DATETIME)
            //UI labels.
            @Pkg(label = "Source start date and time variable")
            //Ensure that a validation error is thrown when the value is null.
            @NotEmpty
            ZonedDateTime startTime,

            @Idx(index = "2", type = DATETIME)
            @Pkg(label = "Source end date and time variable")
            @NotEmpty
            ZonedDateTime endTime,

            @Idx(index =  "3", type = SELECT, options = {
                    @Idx.Option(index = "3.1", pkg = @Pkg(label = "Second", value = "Second")),
                    @Idx.Option(index = "3.2", pkg = @Pkg(label = "Minute", value = "Minute")),
                    @Idx.Option(index = "3.3", pkg = @Pkg(label = "Hour", value = "Hour")),
                    @Idx.Option(index = "3.4", pkg = @Pkg(label = "Day", value = "Day")),
                    @Idx.Option(index = "3.5", pkg = @Pkg(label = "Month", value = "Month"))
            })
            @Pkg(label = "Select time unit")
            @NotEmpty
            String timeUnit) {

        long result = 0;
        //Business logic
        Duration duration = Duration.between(
                startTime,
                endTime);

        switch (timeUnit){
            case "Second":
                result = duration.getSeconds();
                break;
            case "Minute":
                result = (duration.getSeconds() / 60);
                break;
            case "Hour":
                result = (duration.getSeconds() / 3600);
                break;
            case "Day":
                result = (duration.toDays());
                break;
            case "Month":
                result = ChronoUnit.MONTHS.between(startTime,endTime);

        }

        //Return StringValue.
        return new NumberValue(result);
    }
}
