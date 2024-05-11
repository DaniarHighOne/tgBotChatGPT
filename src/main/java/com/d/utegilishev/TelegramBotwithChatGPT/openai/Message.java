package com.d.utegilishev.TelegramBotwithChatGPT.openai;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Message {

    private final String role;
    private final String content;

}
