package com.d.utegilishev.TelegramBotwithChatGPT.openai;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@AllArgsConstructor
public class aiClient {

    private final String token;

    private final RestTemplate restTemplate;

    public chatComplitionObject createChatComplition(
            String message
    ) {
        String url = "https://api.openai.com/v1/chat/completions";
        //add headers to request
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer" + token);
        httpHeaders.set("Content-type", "application/json");

        String request = """
                {
                "model": "gpt-3.5-turbo",
                    "messages": [
                      {
                        "role": "system",
                        "content": "You are assistant."
                      },
                      {
                        "role": "user",
                        "content": "%s"
                      }
                    ]
                  }
                """.formatted(message);

        HttpEntity<String> httpEntity = new HttpEntity<>(request,httpHeaders);

        ResponseEntity<chatComplitionObject> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, httpEntity, chatComplitionObject.class
        );
        return responseEntity.getBody();
    }


}
