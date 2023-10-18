package pro.sky.telegrambot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramBotKeyBoard {
    private Logger logger = LoggerFactory.getLogger(TelegramBotKeyBoard.class);
    private final String CHOOSE_TEXT = "Выберите, что Вас интересует";

    //Метод для получения стартового меню бота
    public SendMessage startMenu(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Здраствуй, дорогой посетитель!\n"+
                "Я бот который поможет Вам выбрать питомца. Общаясь со мной, можно узнать:\n" +
                "Миссию и историю приюта\n" +
                "Наши ценности и принципы работы\n" +
                "Общую информацию для желающих взять питомца из приюта\n" +
                "Получать поддержку и консультации волонтёров\n" +
                "\n"+
                "Пожалуйста, выберите приют!");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setCallbackData("CatShelter");
        button1.setText("Приют для кошек");


        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Приют для собак");
        button2.setCallbackData("DogShelter");

        row1.add(button1);
        row1.add(button2);

        buttons.add(row1);

        markup.setKeyboard(buttons);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }
    //---------------------------------------Методы для приюта кошек-------------------------------------------------
    public SendMessage catShelter(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Выберите, что Вас интересует");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Информация о приюте");
        button1.setCallbackData("CatShelterInfo");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Как взять животное из приюта");
        button2.setCallbackData("TakeCat");

        row1.add(button1);
        row1.add(button2);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton button3= new InlineKeyboardButton();
        button3.setText("Прислать отчет о питомце");
        button2.setCallbackData("SendReport");
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText("Задать вопрос волонтеру");
        button2.setCallbackData("CallVolunteer");

        row2.add(button3);
        row2.add(button4);

        buttons.add(row1);
        buttons.add(row2);

        markup.setKeyboard(buttons);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }

    //Метод для получения информации о приюте кошек
    public SendMessage catShelterInfo(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(CHOOSE_TEXT);

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        List<InlineKeyboardButton> row4 = new ArrayList<>();
        List<InlineKeyboardButton> row5 = new ArrayList<>();
        List<InlineKeyboardButton> row6 = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton("Общая информация");
        button1.setCallbackData("GeneralCatShelterInfo");
        row1.add(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton("Расписание работы приюта и адрес");
        button2.setCallbackData("CatShelterContacts");
        row2.add(button2);

        InlineKeyboardButton button3= new InlineKeyboardButton(
                "Контактные данные охраны для оформления пропуска на машину");
        button2.setCallbackData("CatShelterSecurityContacts");
        row3.add(button3);

        InlineKeyboardButton button4 = new InlineKeyboardButton(
                "Рекомендации о технике безопасности на территории приюта");
        button2.setCallbackData("CatShelterSafetyRules");
        row4.add(button4);

        InlineKeyboardButton button5 = new InlineKeyboardButton("Оставить контактные данные для связи");
        button2.setCallbackData("UserContacts");
        row5.add(button5);

        InlineKeyboardButton button6 = new InlineKeyboardButton("Задать вопрос волонтеру");
        button2.setCallbackData("CallVolunteer");
        row6.add(button6);

        buttons.add(row1);
        buttons.add(row2);
        buttons.add(row3);
        buttons.add(row4);
        buttons.add(row5);
        buttons.add(row6);

        markup.setKeyboard(buttons);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }
    //Метод для получения общей информации и приюте для кошек
    public SendMessage generalCatShelterInfo(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Мы любим людей и животных, поэтому помогаем друг другу и обучаем людей, " +
                        "как заботиться о питомцах профессионально и с любовью!" +
                "О нас:\n"+
        "Кошкин Дом - это приют для кошек в г. Астана. Мы работаем уже 5 лет. За это время мы приняли, вылечили и адаптировали " +
                        "к жизни в новых домах несколько сотен животных, а также обучили не один десяток волонтёров, " +
                        "как взаимодействовать с разными животными. У нас есть свои традиции, правила и принципы работы, " +
                        "при этом мы открыты к новому, используя современные технологии!\n"+
                "Наши ценности:\n"+
        "Забота о питомце, оказавшемся в беде\n"+
        "Помощь в обретении нового дома каждому нашему питомцу\n"+
        "Сопровождение новых хозяев на первых порах и необходимая поддержка в любое время\n"+
        "Полное соблюдение законодательства\n"+
        "Поддержание и развитие профессионализма сотрудников и волонтёров приюта\n"+
        "Полная отчётность всем жертвователям приюта\n"+
        "Наша команда:\n"+
        "С нами сотрудничают студенты ветеринарной Академии и неравнодушные любители животных. " +
                "Мы знаем, как  вылечить и адаптировать животное к жизни в новом доме, поможем Dам " +
                "привыкнуть друг к другу и будем  вас вести на протяжении всего испытательного срока, " +
                "чтобы ваш новый питомец был в радость новым усыновителям!");
        return sendMessage;
    }
}


