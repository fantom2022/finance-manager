package com.artg.financemanager.config;

import com.artg.financemanager.bots.AccountingBot;
import com.artg.financemanager.bots.CoffeeBot;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Log4j2
@Component
public class Initilizer {

    @Autowired
    AccountingBot accountingBot;

    @Autowired
    CoffeeBot coffeeBot;

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            //telegramBotsApi.registerBot(coffeeBot);
            telegramBotsApi.registerBot(accountingBot);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());

        }
    }
}
