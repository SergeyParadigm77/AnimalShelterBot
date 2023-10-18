package pro.sky.telegrambot.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("application.properties")
public class TelegramBotConfiguration {

    @Value("${telegram.bot.name}")
    String botName;
    @Value("${telegram.bot.token}")
    String botToken;


}
