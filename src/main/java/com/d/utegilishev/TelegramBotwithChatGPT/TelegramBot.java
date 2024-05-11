package com.d.utegilishev.TelegramBotwithChatGPT;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.d.utegilishev.TelegramBotwithChatGPT.openai.aiClient;

public class TelegramBot extends TelegramLongPollingBot {

    private final aiClient openAIClient;

    public TelegramBot(DefaultBotOptions options, String botToken, aiClient openAIClient ) {
        super(options, botToken);
        this.openAIClient = openAIClient;

    }


    @Override
    @SneakyThrows//for checking throws exceptions
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var text = update.getMessage().getText();
            var chatId = update.getMessage().getChatId();
            //implement response from gpt
            var chatComplitionResponse = openAIClient.createChatComplition(text);
            var textResponse = chatComplitionResponse.getChoices().get(0).getMessage().getContent();
            SendMessage sendMessage = new SendMessage(chatId.toString(), textResponse);
            sendApiMethod(sendMessage);
        }
    }

    @Override
    public String getBotUsername() {
        return "MyTestBot";
    }
}
