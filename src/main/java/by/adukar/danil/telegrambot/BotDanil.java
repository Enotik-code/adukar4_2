package by.adukar.danil.telegrambot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Document;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BotDanil extends TelegramLongPollingBot {

    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    ArrayList<String> history = new ArrayList<>();
    HashMap<Integer, ArrayList<String>> main2 = new HashMap<>();
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String month = Integer.toString(date.getMonthValue());
        String day = Integer.toString(date.getDayOfMonth());
        String hour = Integer.toString(time.getHour());
        String minute = Integer.toString(time.getMinute());
        String second = Integer.toString(time.getSecond());
        String final_history = "";
        int id = update.getMessage().getChatId().intValue();
        if (main2.containsKey(id)) { history = main2.get(id); }
        else {main2.put(id, new ArrayList<>());}


        history = main2.get(id);
        if(message.equals("/start")) {
            sendMsg("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + "\nВот команды, которые я могу для вас выполнить:\n1) /start - Начать\n2) /help - Помощь для работы с ботом\n3) /commands - Показать список всех команд\n4) /time - Показать текущую дату и время\n5)/translate - Начать переводить текст\n6)/history - История запросов на время\n6)/clear - Очистить историю времени", update.getMessage().getChatId());
        }
        if(message.equals("/help")) {
            sendMsg("Для того чтобы начатьпереводить текст, напишите /translate, и впишите текст нужный для перевода, для завершения работы переводчика, впишите /exit. Приятного пользования TranslatorBot!", update.getMessage().getChatId());
        }
        if(message.equals("/translate")) {
            sendMsg("Введите текст для перевода. \n/exit - Перестать переводить текст.", update.getMessage().getChatId());
        }
        if(message.equals("/commands")) {
            sendMsg("/start - Начать \n/help - Помощь \n/commands - Все команды \n/time - Время и дата \n/translate - Начать перевод \n/exit - Остановить перевод \n/history - История просмотра времени \n/clear - Очистить историю времени", update.getMessage().getChatId());
        }
        if(message.equals("/time")) {

            if (date.getMonthValue() < 10) {month = "0" + Integer.toString(date.getMonthValue());}
            if (date.getDayOfMonth() < 10) {day = "0" + Integer.toString(date.getDayOfMonth());}
            if (time.getHour() < 10) {hour = "0" + Integer.toString(time.getHour());}
            if (time.getMinute() < 10) {minute = "0" + Integer.toString(time.getMinute());}
            if (time.getSecond() < 10) {second = "0" + Integer.toString(time.getSecond());}
            sendMsg(date.getYear() +"-"+ month +"-"+ day +"\n"+ hour +":"+ minute +":"+ second, update.getMessage().getChatId());
            history.add(date.getYear() +"-"+ month +"-"+ day +" | "+ hour +":"+ minute +":"+ second);
        }
        if(message.equals("/history")) {
            if (history.size() != 0) {
                for (int i = 0; i < history.size(); i++) {
                    final_history = final_history + (i + 1) + ") | " + history.get(i) + "\n";
                }
                final_history = final_history + "/clear";
            } else {
                final_history = "Ваша история времени пуста.";
            }
            sendMsg(final_history + "", update.getMessage().getChatId());
        }
        if(message.equals("/clear")) {
            history.clear();
            final_history = "";
            main2.remove(id);
            sendMsg("История успешно очищена", update.getMessage().getChatId());
        }
        main2.put(id, history);
        System.out.println(main2);
    }


    public synchronized void sendMsg(String s, long chat_id) {

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