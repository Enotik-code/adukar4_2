package by.adukar.danil.telegrambot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotDanil extends TelegramLongPollingBot {

    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();

        if(message.equals("/start")) {
            sendMsg("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + " \n Вот команды, которые я могу для вас выполнить: \n 1. /start - Начать. \n 2. /help - Помощь для работы с ботом. \n 3. /commands - Показать список всех команд. \n 4. /time - Показать текущую дату и время.", update.getMessage().getChatId());
        }
        if(message.equals("/help")) {
            sendMsg("Помощь уже в пути", update.getMessage().getChatId());
        }
        else{
            sendMsg(update.getMessage().getText(), update.getMessage().getChatId());
        }
        System.out.println();
    }


    public synchronized void sendMsg(String s, Long chat_id) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id);
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
        return "TranslatorDanil_bot";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return "1664772721:AAEesVvTis2sy8NsvOLKs3OcB_Q2Lan-Vns";
    }
}