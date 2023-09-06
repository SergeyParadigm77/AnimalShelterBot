package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.service.TelegramSenderService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    private final TelegramSenderService telegramSenderService;
    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
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
            Long chatId = update.message().chat().id();
            String message = update.message().text();

            if ("/start".equals(message)) {
                telegramSenderService.send(chatId, "Привет, друг!");
            }
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }
    }










