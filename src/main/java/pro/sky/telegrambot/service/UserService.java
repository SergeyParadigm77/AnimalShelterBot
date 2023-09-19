package pro.sky.telegrambot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.User;
import pro.sky.telegrambot.repository.UserRepository;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        logger.info("Method createUser was invoked");
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        logger.info("Method getUser was invoked");
        return userRepository.findById(id).orElse(null);
    }
}