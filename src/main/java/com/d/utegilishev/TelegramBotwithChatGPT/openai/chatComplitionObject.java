package com.d.utegilishev.TelegramBotwithChatGPT.openai;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class chatComplitionObject {

    private final List<Choice> choices;
}
