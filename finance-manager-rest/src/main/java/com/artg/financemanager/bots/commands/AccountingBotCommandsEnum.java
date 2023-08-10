package com.artg.financemanager.bots.commands;

public enum AccountingBotCommandsEnum {
    START("start"),
    HELP("help"),
    INCOME("income"),
    CONSUMPTION("consumption"),
    MENU("menu"),
    ACCOUNT("account");

    private final String text;

    AccountingBotCommandsEnum(String value) {
        this.text = value;
    }

    public String command() {
        return "/" + this.text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
