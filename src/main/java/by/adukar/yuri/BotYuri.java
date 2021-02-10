package by.adukar.yuri;

import by.adukar.danil.telegrambot.time.TimeService;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Document;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotYuri extends TelegramLongPollingBot {
    String word;
    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();

        if(message.equals("/replace")){
            StringBuffer strBuffer = new StringBuffer("hello world!");
            String str1 = strBuffer.substring(6,strBuffer.length());
            System.out.println(str1);
            sendMsg(str1,update.getMessage().getChatId());
            System.out.print("Возвращаемое значение: ");
            System.out.println(str1.replace('o','a'));
            String str2 = str1.replace('o','a');
            sendMsg("Возвращаемое значение: " + str2, update.getMessage().getChatId());


        }






        /*StringBuffer strBuffer2 = new StringBuffer("hello java!");
        String str4 = strBuffer1.substring(6); // обрезка строки с 6 символа до конца
        System.out.println(str4); //java!

        String str2 = strBuffer1.substring(3, 9); // обрезка строки с 3 по 9 символ
        System.out.println(str2); //lo jav

        String Str = new String("Добро пожаловать на ProgLang.su");

        System.out.print("Возвращаемое значение: " );
        System.out.println(Str.replace('s', 'b'));

        System.out.print("Возвращаемое значение: " );
        System.out.println(Str.replace('о', 'а'));








        if(message.equals("/replace")){
            word = word.substring(9, message.length());
            sendMsg(word.replace('o', 'a'), update.getMessage().getChatId());
            System.out.println(word);
            sendMsg("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + "!", update.getMessage().getChatId());
        }

         */

        if(message.equals("/start")){
            sendMsg("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + "!", update.getMessage().getChatId());
        }
        if(message.equals("/help")){
            sendMsg("Команды для работы с ботом: /start - начало чата, /help - список команд /replace", update.getMessage().getChatId());
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
