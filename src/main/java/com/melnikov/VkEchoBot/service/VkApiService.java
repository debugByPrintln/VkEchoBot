package com.melnikov.VkEchoBot.service;

import com.melnikov.VkEchoBot.POJO.VkMessage;
import com.melnikov.VkEchoBot.controller.BotController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class VkApiService {

    @Value("${vk.api.token}")
    private String token;

    @Value("${vk.api.version}")
    private String apiVersion;

    private final RestTemplate restTemplate = new RestTemplate();
    private static final Logger logger = LoggerFactory.getLogger(VkApiService.class);
    private final Random random = new Random();

    public String sendMessage(String userId, String message) {
        int randomId = random.nextInt(Integer.MAX_VALUE);
        logger.info("Sending message to user ID {}: {}", userId, message);
        String url = String.format("https://api.vk.com/method/messages.send?user_id=%s&message=%s&random_id=%d&access_token=%s&v=%s",
                userId, message, randomId, token, apiVersion);
        String response = restTemplate.getForObject(url, String.class);
        logger.info("Response from VK API: {}", response);
        return response;
    }
}