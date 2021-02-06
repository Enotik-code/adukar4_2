package by.adukar.telegrambot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotYuri extends TelegramLongPollingBot {

    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        if(update.getMessage().getText().equals("Привет")) {
            sendMsg("Занимайся дальше не буду отвлекать.");
        }

        
        else{
            sendMsg(update.getMessage().getText());
        }
    }


    public synchronized void sendMsg(String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(1385600926L);
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
        return "HelpSallesBot ";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return "1603408622:AAEnS0G5hKgX5ycrZBhDoiIf9Bq1UPLuITU";
    }
}