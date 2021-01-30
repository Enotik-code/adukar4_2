package by.adukar.kirill.telegrambot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotKirill extends TelegramLongPollingBot {

    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        if(update.getMessage().getText().equals("/help")) {
            sendMsg("Сам себе помоги");
        }
        else{
            sendMsg(update.getMessage().getText());
        }
    }


    public synchronized void sendMsg(String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(973462913L);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println( "Exception: " + e.toString());
        }
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return "Caseroll_bot";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return "1554276961:AAERMM7y8T8aXxxEWFnJZ42aC-6UcaPizfE";
    }
}