package com.example.pupupu.configs;

import com.example.pupupu.tgBot.TelegramBot;
import com.example.pupupu.tgBot.TelegramFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
public class AppConfig {
    private final TelegramBotConfig botConfig;

    public AppConfig(TelegramBotConfig btelegramBotConfig) {
        this.botConfig = btelegramBotConfig;
    }

}