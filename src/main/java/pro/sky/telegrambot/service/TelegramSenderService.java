package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TelegramSenderService {
    private Logger logger = LoggerFactory.getLogger(TelegramSenderService.class);
    private final TelegramBot telegramBot;

    public TelegramSenderService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void send(long chatId, String message) {
        /*getKeyboard(chatId);*/
        SendMessage sendMessage = new SendMessage(chatId, message);
        SendResponse response = telegramBot.execute(sendMessage);

        if (!response.isOk()) {
            logger.error("Error ocured during sending message to bot. Error: " + response.description());
        }
    }

    public void getKeyboard1(long chatId) {
        InlineKeyboardButton[] keyboard1 = {new InlineKeyboardButton("Приют для кошек").callbackData("Test1"), new InlineKeyboardButton("Приют для собак").callbackData("Test2")};
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup(keyboard1);
        SendMessage myMessage1 = new SendMessage(chatId, "Привет, посетитель! Я - бот, который поможет тебе выбрать маленького пушистого друга!").replyMarkup(inlineKeyboardMarkup);
        SendResponse response = telegramBot.execute(myMessage1);
    }

    public void getKeyboard2(long chatId) {
        InlineKeyboardButton[] keyboard2 = {new InlineKeyboardButton("Инфа о приюте").callbackData("Test3"), new InlineKeyboardButton("Взять кошечку").callbackData("Test4"), new InlineKeyboardButton("Отчет о содержании").callbackData("Test5")};
        InlineKeyboardMarkup inlineKeyboardMarkup2 = new InlineKeyboardMarkup(keyboard2);
        SendMessage myMessage2 = new SendMessage(chatId, "Ты находишься в меню приюта для кошек!").replyMarkup(inlineKeyboardMarkup2);
        SendResponse response = telegramBot.execute(myMessage2);
    }
    public void getKeyboard3(long chatId) {
        InlineKeyboardButton[] keyboard3 = {new InlineKeyboardButton("Инфа о приюте").callbackData("Test6"), new InlineKeyboardButton("Взять собачку").callbackData("Test7"), new InlineKeyboardButton("Отчет о содержании").callbackData("Test8")};
        InlineKeyboardMarkup inlineKeyboardMarkup3 = new InlineKeyboardMarkup(keyboard3);
        SendMessage myMessage3 = new SendMessage(chatId, "Ты находишься в меню приюта для собак!").replyMarkup(inlineKeyboardMarkup3);
        SendResponse response = telegramBot.execute(myMessage3);
    }
}

