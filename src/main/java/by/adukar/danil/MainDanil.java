package by.adukar.danil;

import by.adukar.example.telegrambot.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class MainDanil {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new BotDanil());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
