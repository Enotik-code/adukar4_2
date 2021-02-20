package by.adukar.yuri;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotYuri extends TelegramLongPollingBot {
    String word;
    boolean key;
    boolean key11;
    String num11 = new String("о");
    String num12 = new String("а");
    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        String rep = new String("/replace");
        String unrep = new String("/unrep");
        if(message.equals("/replace")){
            key = true;
            sendMsg("Привет",update.getMessage().getChatId());
        }
        if(key==true && !message.equals(rep) && !message.equals(unrep)){
            String str=message;
            System.out.print(str.replaceAll(num11,num12));
            sendMsg(str.replace('о','а'),update.getMessage().getChatId());

        }
        if(message.equals("/unrep")){
            key = false;
            sendMsg("/replace - отключено",update.getMessage().getChatId());
        }

        if(message.equals("/start")){
            sendMsg("Здравствуйте, " + update.getMessage().getFrom().getFirstName() + "!", update.getMessage().getChatId());
        }
        if(message.equals("/help")){
            sendMsg("Команды для работы с ботом: /start - начало чата, /help - список команд /replace /unrep", update.getMessage().getChatId());
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
    public String getBotUsername() { return "HelpSellBot "; }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    @Override
    public String getBotToken() { return "1690224543:AAFr8hrbiWNYB3GbqtDupLTPUd8-T8PVX80"; }
}
