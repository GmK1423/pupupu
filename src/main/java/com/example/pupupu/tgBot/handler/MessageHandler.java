package com.example.pupupu.tgBot.handler;

import com.example.pupupu.cash.BotStateCash;
import com.example.pupupu.services.MenuService;
import com.example.pupupu.services.RestService;
import com.example.pupupu.tgBot.BotState;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class MessageHandler {

    private final RestService restService;
    private final MenuService menuService;
    private final BotStateCash botStateCash;
    private final MainHandler mainHandler;

    public MessageHandler(RestService restService, MenuService menuService, BotStateCash botStateCash, MainHandler mainHandler) {
        this.restService = restService;
        this.menuService = menuService;
        this.botStateCash = botStateCash;
        this.mainHandler = mainHandler;
    }

    public BotApiMethod<?> handle(Message message, BotState botState) {
        long userId = message.getFrom().getId();
        long chatId = message.getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        //if new user
//        if (!restService.isExist(userId)) {
//            return eventHandler.saveNewUser(message, userId, sendMessage);
//        }
        //save state in to cache
        botStateCash.saveBotState(chatId, botState);
        //if state =...
        switch (botState.name()) {
            case ("START"):
                return menuService.getMainMenuMessage(message.getChatId(),
                        "Воспользуйтесь главным меню");
            case ("ALLUSERS"):
                //only admin
                return mainHandler.allUsers(userId);
            case ("ENTERNUMBERUSER"):
                //only admin
                return mainHandler.removeUserHandler(message, userId);
            default:
                throw new IllegalStateException("Unexpected value: " + botState);
        }
    }
}
