package by.adukar.veronika.telegrambot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotVeronika extends TelegramLongPollingBot {

    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        if(message.equals("/start")) {
            sendMsg("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + "!", update.getMessage().getChatId());
        }
        if(message.equals("/help")) {
            sendMsg("Команды для работы с ботом: /start - начало чата, /help - список команд", update.getMessage().getChatId());
        }
        //else{
        //sendMsg(update.getMessage().getText(), update.getMessage().getChatId());
        //}
    }


    public synchronized void sendMsg(String s, Long chat_id) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Exception: " + e.toString());
        }
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     * @return имя бота
     */

    @Override
    public String getBotUsername() {
        return "sportReporterBot";
    }

    @Override
    public String getBotToken() {
        return "1658416657:AAEgNrGXhH-swL7Zlt7uJ1a1wZDdhB-puq4";
    }
}