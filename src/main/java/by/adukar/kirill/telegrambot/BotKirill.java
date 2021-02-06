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
        int answer1=0;
        int answer=0;
        int max = 0;
        int min = 0;

        if(update.getMessage().getText().equals("/random1")) {
            double result = Math.random()*100;
             answer = (int) (result*100);
            sendMsg(answer+"");
            System.out.println(result);
        }
        else{
            sendMsg(update.getMessage().getText());
        }
        if(update.getMessage().getText().equals("/random2")) {
            double result1 = Math.random()*100;
             answer1 = (int) (result1*100);
            sendMsg(answer1+"");
            System.out.println(result1);
        }
        else{
            sendMsg(update.getMessage().getText());
        }
        if(answer>answer1){
            min = answer1;
        }
        else {
            min=answer;
        }

        if(update.getMessage().getText().equals("/min" )) {
            sendMsg(min+"");


        }
        else{
            sendMsg(update.getMessage().getText());
        }
        if(answer>answer1){
            max=answer;
        }
        else{
            max=answer1;
        }
        if(update.getMessage().getText().equals("/max" )) {
            sendMsg(max+"");

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