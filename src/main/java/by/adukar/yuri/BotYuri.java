package by.adukar.yuri;

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
        var re = /яблоки/gi;
        var str = 'Яблоки круглые и яблоки сочные.';
        var newstr = str.replace(re, 'апельсины');
        console.log(newstr); // апельсины круглые и апельсины сочные.

        String message = update.getMessage().getText();
        sendMsg(message);

        String mes = update.getMessage().getText();
        sendMsg(mes);


        /*String message = update.getMessage().getText();
        if(message.equals("/start")){
            sendMsg("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + "!", update.getMessage().getChatId());
        }
        if(message.equals("/help")){
            sendMsg("Команды для работы с ботом: /start - начало чата, /help - список команд", update.getMessage().getChatId());
        }

             */
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
