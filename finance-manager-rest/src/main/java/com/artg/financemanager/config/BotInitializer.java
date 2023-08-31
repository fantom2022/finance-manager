package com.artg.financemanager.config;

import com.artg.financemanager.bots.AccountingBot;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Log4j2
@Component
public class BotInitializer {

    final AccountingBot accountingBot;


    public BotInitializer(AccountingBot accountingBot) {
        this.accountingBot = accountingBot;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(accountingBot);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());

        }
    }
}
