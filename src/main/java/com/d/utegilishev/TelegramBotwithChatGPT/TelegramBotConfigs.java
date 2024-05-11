package com.d.utegilishev.TelegramBotwithChatGPT;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import com.d.utegilishev.TelegramBotwithChatGPT.openai.*;

@Configuration
public class TelegramBotConfigs {

    @Bean
    @SneakyThrows
    public TelegramBot telegramBot(
            @Value("${bot.token}") String botToken,
            TelegramBotsApi telegramBotsApi,
            aiClient openAIClient

    )
     {
        var botOptions = new DefaultBotOptions();

        var bot = new TelegramBot(botOptions,botToken, openAIClient);
        telegramBotsApi.registerBot(bot);
        return bot;
    }

    @Bean
    @SneakyThrows
    public TelegramBotsApi telegramBotsApi(){
        return new TelegramBotsApi(DefaultBotSession.class);

    }
}
