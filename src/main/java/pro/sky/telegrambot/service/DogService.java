package pro.sky.telegrambot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Dog;
import pro.sky.telegrambot.repository.DogRepository;

@Service
public class DogService {
    Logger logger = LoggerFactory.getLogger(DogService.class);
    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }
    public Dog createDog(Dog dog) {
        logger.info("Method createDog was invoked");
        return dogRepository.save(dog);
    }

    public Dog getDog(Long id) {
        logger.info("Method getDog was invoked");
        return dogRepository.findById(id).orElse(null);
    }
}
