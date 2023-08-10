package com.artg.financemanager.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AccountingBotConfig {
    @Value("${bot.accounting.name}")
    private String botName;
    @Value("${bot.accounting.token}")
    private String token;
}
