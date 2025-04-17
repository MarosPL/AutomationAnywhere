package com.automationanywhere;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DifferenceCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(DifferenceCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    Difference command = new Difference();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("startTime") && parameters.get("startTime") != null && parameters.get("startTime").get() != null) {
      convertedParameters.put("startTime", parameters.get("startTime").get());
      if(convertedParameters.get("startTime") !=null && !(convertedParameters.get("startTime") instanceof ZonedDateTime)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","startTime", "ZonedDateTime", parameters.get("startTime").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("startTime") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","startTime"));
    }

    if(parameters.containsKey("endTime") && parameters.get("endTime") != null && parameters.get("endTime").get() != null) {
      convertedParameters.put("endTime", parameters.get("endTime").get());
      if(convertedParameters.get("endTime") !=null && !(convertedParameters.get("endTime") instanceof ZonedDateTime)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","endTime", "ZonedDateTime", parameters.get("endTime").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("endTime") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","endTime"));
    }

    if(parameters.containsKey("timeUnit") && parameters.get("timeUnit") != null && parameters.get("timeUnit").get() != null) {
      convertedParameters.put("timeUnit", parameters.get("timeUnit").get());
      if(convertedParameters.get("timeUnit") !=null && !(convertedParameters.get("timeUnit") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","timeUnit", "String", parameters.get("timeUnit").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("timeUnit") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","timeUnit"));
    }
    if(convertedParameters.get("timeUnit") != null) {
      switch((String)convertedParameters.get("timeUnit")) {
        case "Second" : {

        } break;
        case "Minute" : {

        } break;
        case "Hour" : {

        } break;
        case "Day" : {

        } break;
        case "Month" : {

        } break;
        default : throw new BotCommandException(MESSAGES_GENERIC.getString("generic.InvalidOption","timeUnit"));
      }
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.action((ZonedDateTime)convertedParameters.get("startTime"),(ZonedDateTime)convertedParameters.get("endTime"),(String)convertedParameters.get("timeUnit")));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","action"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }

  public Map<String, Value> executeAndReturnMany(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return null;
  }
}
