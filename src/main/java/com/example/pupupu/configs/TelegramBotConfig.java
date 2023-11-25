package com.example.pupupu.configs;

import com.example.pupupu.tgBot.TelegramBot;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.concurrent.Exchanger;

@Configuration
@PropertySource("application.properties")
@Getter
public class TelegramBotConfig {

    String botPath;
    @Value("${bot.name}")
    String botName;
    @Value("${bot.key}")
    String token;
    @Value("${telegrambot.adminId}")
    long adminId;


    @Bean
    public TelegramBotsApi telegramBotsApi(TelegramBot telegramBot) throws TelegramApiException {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(telegramBot);
        return api;
    }
}
