package com.artg.financemanager.bots.commands;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface AccountingBotCommands {
    List<BotCommand> LIST_COMMANDS = List.of(
            new BotCommand(AccountingBotCommandsEnum.START.toString(), "запуск бота"),
            new BotCommand(AccountingBotCommandsEnum.HELP.toString(), "помощь по командам бота"),
            new BotCommand(AccountingBotCommandsEnum.INCOME.toString(), "доход"),
            new BotCommand(AccountingBotCommandsEnum.CONSUMPTION.toString(), "расход"),
            new BotCommand(AccountingBotCommandsEnum.MENU.toString(), "меню")
    );

    String HELP_TEXT = "Ассист-финансист.\nДоступные команды бота:\n" +
            LIST_COMMANDS.stream().map((c) -> "/" + c.getCommand() + " - " + c.getDescription()).collect(Collectors.joining("\n"));

}
