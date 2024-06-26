package com.d.utegilishev.TelegramBotwithChatGPT.openai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class openAIConfig {

    @Bean
    public aiClient openAIClient(
            @Value("${openai.token}") String botToken,
            RestTemplateBuilder restTemplateBuilder//init automatically
    ){
        return new aiClient(botToken, restTemplateBuilder.build());
    }
}
