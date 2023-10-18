package pro.sky.telegrambot.listener;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import pro.sky.telegrambot.configuration.TelegramBotConfiguration;
import pro.sky.telegrambot.service.TelegramBotKeyBoard;

@Component
@Log4j
public class TelegramBotRun extends TelegramLongPollingBot {
    private final TelegramBotConfiguration configuration;
    private final TelegramBotKeyBoard botKeyBoard;

    public TelegramBotRun(TelegramBotConfiguration configuration, TelegramBotKeyBoard botKeyBoard) {
        this.configuration = configuration;
        this.botKeyBoard = botKeyBoard;
    }

    @Override
    public String getBotUsername() {
        return configuration.getBotName();
    }

    @Override
    public String getBotToken() {
        return configuration.getBotToken();
    }
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            if (message.contains("/start")) {
                execute(botKeyBoard.startMenu(chatId));
            }
        } else if (update.hasCallbackQuery()) {
            String callBackData = update.getCallbackQuery().getData();
            Long chatId = update.getCallbackQuery().getMessage().getChatId();
            if (callBackData.contains("CatShelter")) {
                execute(botKeyBoard.catShelter(chatId));
            }
            if (callBackData.contains("CatShelterInfo")) {
                execute(botKeyBoard.catShelterInfo(chatId));
            }
            if (callBackData.contains("GeneralCatShelterInfo")) {
                execute(botKeyBoard.generalCatShelterInfo(chatId));
            }
        }
    }
}










