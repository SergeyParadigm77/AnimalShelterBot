package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.service.TelegramSenderService;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    private final TelegramSenderService telegramSenderService;
    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
    private final static Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z]");
    private final TelegramBot telegramBot;

    public TelegramBotUpdatesListener(TelegramSenderService telegramSenderService, TelegramBot telegramBot) {
        this.telegramSenderService = telegramSenderService;
        this.telegramBot = telegramBot;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);

            if (update.callbackQuery() != null) {
                String data = update.callbackQuery().data();
                long chatIdCallBack = update.callbackQuery().message().chat().id();
                if (data.equals("Test1")) {
                    telegramSenderService.getKeyboard2(chatIdCallBack);
                    telegramSenderService.send(chatIdCallBack, "Пожалуйста, выбери что тебя интересует!");
                }
                if (data.equals("Test2")) {
                    telegramSenderService.getKeyboard3(chatIdCallBack);
                    telegramSenderService.send(chatIdCallBack, "Пожалуйста, выбери что тебя интересует!");
                }
            } else {
                Long chatId = update.message().chat().id();
                String message = update.message().text();

                if ("/start".equals(message)) {
                    telegramSenderService.getKeyboard1(chatId);
                    telegramSenderService.send(chatId, "Пожалуйста, выбери что тебя интересует!");
                } else {
                    telegramSenderService.send(chatId, "Неверный формат сообщения, попробуй еще раз!");
                }
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}









