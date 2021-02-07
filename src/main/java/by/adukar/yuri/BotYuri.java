package by.adukar.yuri;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotYuri extends TelegramLongPollingBot {
    String word;
    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();

        /*if(message.equals("/toUp"+word)) {
            word = word.substring(7, word.length());
            sendMsg(word.toUpperCase(), update.getMessage().getChatId());
        }
        if(message.equals("/toLow"+word)) {
            word = word.substring(8, word.length());
            sendMsg(word.toLowerCase(), update.getMessage().getChatId());
        }

         */

       if(message.equals("/replace")){
           word = word.substring(9, word.length());
           sendMsg(word.replace("а", "о"), update.getMessage().getChatId());
           System.out.println(word);
           sendMsg("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + "!", update.getMessage().getChatId());
       }





        if(message.equals("/start")){
            sendMsg("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + "!", update.getMessage().getChatId());
        }
        if(message.equals("/help")){
            sendMsg("Команды для работы с ботом: /start - начало чата, /help - список команд", update.getMessage().getChatId());
        }



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
    public String getBotUsername() { return "HelpSallesBot "; }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    @Override
    public String getBotToken() { return "1603408622:AAFAJ7FyhBb1R6aYg5HrDAKQkAGgBAhQxFg"; }
}
