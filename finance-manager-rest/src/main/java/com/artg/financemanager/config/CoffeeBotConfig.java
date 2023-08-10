package com.artg.financemanager.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class CoffeeBotConfig {
    @Value("${bot.coffee.name}")
    private String botName;

    @Value("${bot.coffee.token}")
    private String token;
}
