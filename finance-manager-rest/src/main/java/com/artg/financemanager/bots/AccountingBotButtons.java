package com.artg.financemanager.bots;

import com.artg.financemanager.bots.commands.AccountingBotCommandsEnum;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AccountingBotButtons {
    public final KeyboardButton MENU_BUTTON = new KeyboardButton("Меню");
    public final KeyboardButton HELP_BUTTON = new KeyboardButton("Помощь");
    public final KeyboardButton INCOME_BUTTON = new KeyboardButton("Доход");
    public final KeyboardButton CONSUMPTION_BUTTON = new KeyboardButton("Расход");
    public final KeyboardButton ACCOUNT_BUTTON = new KeyboardButton("Счета");

    public Map<KeyboardButton, String> mapButtonCommand() {
        Map<KeyboardButton, String> map = new HashMap<>();
        map.put(MENU_BUTTON, AccountingBotCommandsEnum.MENU.command());
        map.put(HELP_BUTTON, AccountingBotCommandsEnum.HELP.command());
        map.put(INCOME_BUTTON, AccountingBotCommandsEnum.INCOME.command());
        map.put(CONSUMPTION_BUTTON, AccountingBotCommandsEnum.CONSUMPTION.command());
        map.put(ACCOUNT_BUTTON,AccountingBotCommandsEnum.ACCOUNT.command());
        return map;
    }

    public boolean isButtonCommand(String messageCommand) {
        return getButtons().stream().anyMatch((b) -> b.getText().equals(messageCommand));
    }

    public KeyboardButton getButtonByCommand(String messageCommand) {
        return getButtons().stream().filter((b) -> b.getText().equals(messageCommand))
                .findFirst().orElseThrow(() ->
                        new IllegalArgumentException("Команда не обрабатывается. [Команда] = " + messageCommand));
    }

    public String getCommandByButton(KeyboardButton button) {
        return mapButtonCommand().get(button);
    }

    public List<KeyboardButton> getButtons() {
        return this.mapButtonCommand().keySet().stream().toList();
    }
}
