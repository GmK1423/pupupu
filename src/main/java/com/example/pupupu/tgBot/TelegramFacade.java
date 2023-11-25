package com.example.pupupu.tgBot;

import com.example.pupupu.cash.BotStateCash;
import com.example.pupupu.configs.TelegramBotConfig;
import com.example.pupupu.entities.User;
import com.example.pupupu.services.RestService;
import com.example.pupupu.tgBot.handler.CallbackQueryHandler;
import com.example.pupupu.tgBot.handler.MessageHandler;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramFacade {

    final RestService restService;
    final TelegramBotConfig telegramBotConfig;
    final MessageHandler messageHandler;
    final CallbackQueryHandler callbackQueryHandler;
    final BotStateCash botStateCash;



    public TelegramFacade(RestService restService, TelegramBotConfig telegramBotConfig, MessageHandler messageHandler, CallbackQueryHandler callbackQueryHandler, BotStateCash botStateCash) {
        this.restService = restService;
        this.telegramBotConfig = telegramBotConfig;
        this.messageHandler = messageHandler;
        this.callbackQueryHandler = callbackQueryHandler;
        this.botStateCash = botStateCash;
    }

    public BotApiMethod<?> handleUpdate(Update update) {
        List<User> list = restService.readAllUser();
        for(User user: list){
            if(update.getMessage().getChatId().equals(user.getId())){
                if (update.hasCallbackQuery()) {
                    CallbackQuery callbackQuery = update.getCallbackQuery();
                    return null;
                    //callbackQueryHandler.processCallbackQuery(callbackQuery);
                } else {

                    Message message = update.getMessage();
                    if (message != null && message.hasText()) {
                        return handleInputMessage(message);
                    }
                }
                return null;
            }
        }
        return null;

    }

    private BotApiMethod<?> handleInputMessage(Message message) {
        BotState botState;
        String inputMsg = message.getText();
        //we process messages of the main menu and any other messages
        //set state
        switch (inputMsg) {
            case "/start":
                botState = BotState.START;
                break;
            case "Мои напоминания":
                botState = BotState.MYEVENTS;
                break;
            case "Создать напоминание":
                botState = BotState.CREATE;
                break;
            case "Отключить напоминания":
            case "Включить напоминания":
                botState = BotState.ONEVENT;
                break;
            case "All users":
                if (message.getFrom().getId() == telegramBotConfig.getAdminId())
                    botState = BotState.ALLUSERS;
                else botState = BotState.START;
                break;
            case "All events":
                if (message.getFrom().getId() == telegramBotConfig.getAdminId())
                    botState = BotState.ALLEVENTS;
                else botState = BotState.START;
                break;
            default:
                botState = botStateCash.getBotStateMap().get(message.getFrom().getId()) == null?
                        BotState.START: botStateCash.getBotStateMap().get(message.getFrom().getId());
        }
        //we pass the corresponding state to the handler
        //the corresponding method will be called
        return messageHandler.handle(message, botState);

    }
}