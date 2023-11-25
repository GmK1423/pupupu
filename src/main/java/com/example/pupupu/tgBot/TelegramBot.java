package com.example.pupupu.tgBot;

import com.example.pupupu.configs.TelegramBotConfig;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

import java.util.List;

import static com.example.pupupu.tgBot.BotState.START;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Autowired
    private TelegramBotConfig telegramBotConfig;
    @Autowired
    private TelegramFacade telegramFacade;

    public TelegramBot(@Value("${bot.key}") String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(!update.hasMessage() || !update.getMessage().hasText()){
            return;
        }
        telegramFacade.handleUpdate(update);
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return "Test_System_bot";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}