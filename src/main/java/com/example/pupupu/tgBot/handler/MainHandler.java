package com.example.pupupu.tgBot.handler;

import com.example.pupupu.cash.BotStateCash;
import com.example.pupupu.entities.User;
import com.example.pupupu.services.MenuService;
import com.example.pupupu.services.RestService;
import com.example.pupupu.tgBot.BotState;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class MainHandler {

    private final BotStateCash botStateCash;
    private final RestService restService;
    private final MenuService menuService;



    public MainHandler(BotStateCash botStateCash, RestService restService, MenuService menuService) {
        this.botStateCash = botStateCash;
        this.restService = restService;
        this.menuService = menuService;
    }
    public BotApiMethod<?> removeUserHandler(Message message, long userId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        User user;
        long id;
        try {
            id = Long.parseLong(message.getText());
            user = restService.readUser(id);
        } catch (NumberFormatException e) {
            sendMessage.setText("Введенная строка не является числом, попробуйте снова!");
            return sendMessage;
        }
        if (user == null) {
            sendMessage.setText("Введенное число отсутсвует в списке, попробуйте снова!");
            return sendMessage;
        }
        restService.deleteUser(id);
        botStateCash.saveBotState(userId, BotState.START);
        sendMessage.setText("Удаление прошло успешно");
        return sendMessage;
    }


    public BotApiMethod<?> allUsers(long userId) {
        SendMessage replyMessage = new SendMessage();
        replyMessage.setChatId(String.valueOf(userId));
        StringBuilder builder = new StringBuilder();
        List<User> list = restService.readAllUser();
        for (User user : list) {
            builder.append(buildUser(user));
        }
        replyMessage.setText(builder.toString());
        replyMessage.setReplyMarkup(menuService.getInlineMessageButtonsAllUser());
        botStateCash.saveBotState(userId, BotState.START);
        return replyMessage;
    }

    private StringBuilder buildUser(User user) {
        StringBuilder builder = new StringBuilder();
        long userId = user.getId();
        String name = user.getNickname();
        builder.append(userId).append(". ").append(name).append("\n");
        return builder;
    }


}