package com.artg.financemanager.bots;


import com.artg.financemanager.bots.commands.AccountingBotCommands;
import com.artg.financemanager.bots.commands.AccountingBotCommandsEnum;
import com.artg.financemanager.bots.keyboards.AccountingBotKeyboards;
import com.artg.financemanager.config.AccountingBotConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Log4j2
public class AccountingBot extends TelegramLongPollingBot implements AccountingBotCommands {
    @Autowired
    AccountingBotButtons buttons;
    @Autowired
    AccountingBotKeyboards keyboards;

    final AccountingBotConfig accountingBotConfig;
    Long chatId;
    String userName;

    @Override
    public String getBotUsername() {
        return accountingBotConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return accountingBotConfig.getToken();
    }

    public AccountingBot(AccountingBotConfig accountingBotConfig) {
        this.accountingBotConfig = accountingBotConfig;
        try {
            execute(new SetMyCommands(LIST_COMMANDS,
                    new BotCommandScopeDefault(),
                    null));
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            this.chatId = update.getMessage().getChatId();
            this.userName = update.getMessage().getFrom().getUserName();
            Long userId = update.getMessage().getFrom().getId();

            if (update.getMessage().hasText()) {
                String messageText = update.getMessage().getText();
                if (messageText.startsWith("/"))
                    botAnswerOnCommand(messageText);
                else if (buttons.isButtonCommand(messageText))
                    botAnswerOnButtonClick(buttons.getButtonByCommand(messageText));
            }
        }
    }

    private void botAnswerOnButtonClick(KeyboardButton keyboardButtonPressed) {
        if (keyboardButtonPressed != null)
            botAnswerOnCommand(buttons.getCommandByButton(keyboardButtonPressed));
    }

    private void botAnswerOnCommand(String messageText) {
        if (messageText.equals(AccountingBotCommandsEnum.START.command()))
            startBot();
        else if (messageText.equals(AccountingBotCommandsEnum.HELP.command()))
            helpMessage();
        else if(messageText.equals(AccountingBotCommandsEnum.MENU.command()))
            menuMessage();
        else
            unknownCommand(messageText);
    }

    private void menuMessage() {
        SendMessage response = new SendMessage();
        response.setText("Главное меню");
        response.setChatId(chatId);
        response.setReplyMarkup(keyboards.menuKeyboard());
        try {
            execute(response);
        } catch (TelegramApiException ex) {
            log.error(ex.getMessage());
        }
    }

    private void unknownCommand(String messageText) {
        String msg = "Неизвестная команда: " + messageText;
        SendMessage response = new SendMessage();
        response.setText(msg);
        response.setChatId(chatId);
        try {
            execute(response);
            log.warn(msg);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

    private void helpMessage() {
        SendMessage response = new SendMessage();
        response.setText(HELP_TEXT);
        response.setChatId(chatId);
        try {
            execute(response);
        } catch (TelegramApiException ex) {
            log.error(ex.getMessage());
        }
    }

    private void startBot() {
        SendMessage response = new SendMessage();
        response.setChatId(chatId);
        response.setText("Бот запущен");
        response.setReplyMarkup(keyboards.startKeyboard());
        try {
            execute(response);
        } catch (TelegramApiException ex) {
            log.error(ex.getMessage());
        }
    }


}
