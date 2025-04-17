package com.automationanywhere;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;

import java.time.ZonedDateTime;


import static com.automationanywhere.commandsdk.model.AttributeType.*;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

@BotCommand

//CommandPks adds required information to be dispalable on GUI.
@CommandPkg(
        //Unique name inside a package and label to display.
        name = "DatetimeAdvancedDayOfWeek", label = "Get Day Of Week",
        node_label = "Get Day Of Week", description = "Provides with a string - day of week", icon = "DateTime.svg",

        //Return type information. return_type ensures only the right kind of variable is provided on the UI.
        return_label = "Assign the output to variable", return_type = STRING, return_required = true)
public class DayOfWeek {
    //Messages read from full qualified property file name and provide i18n capability.
    private static final Messages MESSAGES = MessagesFactory
            .getMessages("com.automationanywhere.botcommand.samples.messages");

    //Identify the entry point for the action. Returns a Value<String> because the return type is String.
    @Execute
    public Value<String> action(
            //Idx 1 would be displayed first, with a text box for entering the value.
            @Idx(index = "1", type = DATETIME)
            //UI labels.
            @Pkg(label = "Source start date and time variable")
            //Ensure that a validation error is thrown when the value is null.
            @NotEmpty
            ZonedDateTime inputDate) {

        String result = inputDate.getDayOfWeek().toString();

        //Return StringValue.
        return new StringValue(result);
    }
}
