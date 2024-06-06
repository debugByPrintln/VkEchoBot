package com.melnikov.VkEchoBot.controller;

import com.melnikov.VkEchoBot.POJO.VkMessage;
import com.melnikov.VkEchoBot.service.VkApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/callback")
public class BotController {

    @Autowired
    private VkApiService vkApiService;

    @Value("${vk.confirmation.code}")
    private String confirmationCode;

    private static final Logger logger = LoggerFactory.getLogger(BotController.class);

    @PostMapping
    public String handleMessage(@RequestBody VkMessage message) {
        logger.info("Received new message: {}", message);
        if ("confirmation".equals(message.getType())) {
            logger.info("Sending confirmation code: {}", confirmationCode);
            return confirmationCode;
        }
        if ("message_new".equals(message.getType())) {
            String userId = message.getObject().getMessageDetail().getFromId();
            String userMessage = message.getObject().getMessageDetail().getText();
            logger.info("Processing message from user ID {}: {}", userId, userMessage);
            vkApiService.sendMessage(userId, "Вы сказали: " + userMessage);
        }
        return "ok";
    }
}