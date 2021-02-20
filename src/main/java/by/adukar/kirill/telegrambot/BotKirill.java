package by.adukar.kirill.telegrambot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotKirill extends TelegramLongPollingBot {

    /**
     * Метод для приема сообщений.
     *
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        int answer1 = 0;
        int answer = 0;
        int max = 0;
        int min = 0;

        if (update.getMessage().getText().equals("/random1")) {
            sendMsg(Math.random() * 100 + " ");
        }
        if (update.getMessage().getText().equals("/random2")) {
            int res1 = (int) (Math.random() * 100);
            int res2 = (int) (Math.random() * 100);
            int min2 = Math.min(res1, res2);

            sendMsg(res1 +  " " +  res2);
            sendMsg("Минимальное число " + min2);
        }
        else {
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
            System.out.println("Exception: " + e.toString());
        }
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     *
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return "Caseroll_bot";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     *
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return "1554276961:AAERMM7y8T8aXxxEWFnJZ42aC-6UcaPizfE";
    }
}