package com.artg.financemanager.bots.keyboards;

import com.artg.financemanager.bots.AccountingBotButtons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountingBotKeyboards {

    @Autowired
    AccountingBotButtons buttons;

    public ReplyKeyboardMarkup menuKeyboard(){
        List<KeyboardButton> accountBtn = new ArrayList<>();
        accountBtn.add(buttons.ACCOUNT_BUTTON);
        List<KeyboardButton> operationBtn = new ArrayList<>();
        operationBtn.add(buttons.INCOME_BUTTON);
        operationBtn.add(buttons.CONSUMPTION_BUTTON);
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(createKeyboardRow(accountBtn));
        rows.add(createKeyboardRow(operationBtn));
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(rows);
        markup.setResizeKeyboard(true);
        markup.setKeyboard(rows);
        return markup;
    }

    public ReplyKeyboardMarkup startKeyboard() {
        List<KeyboardButton> startButtons = new ArrayList<>();
        startButtons.add(buttons.MENU_BUTTON);
        startButtons.add(buttons.HELP_BUTTON);
        List<KeyboardRow> rows = new ArrayList<>();
        rows.add(createKeyboardRow(startButtons));
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(rows);
        markup.setResizeKeyboard(true);
        markup.setKeyboard(rows);
        return markup;
    }

    private KeyboardRow createKeyboardRow(List<KeyboardButton> buttons) {
        KeyboardRow row = new KeyboardRow();
        row.addAll(buttons);
        return row;
    }

}
