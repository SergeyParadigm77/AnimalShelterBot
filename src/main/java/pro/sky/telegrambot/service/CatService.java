package pro.sky.telegrambot.service;

import liquibase.pro.packaged.C;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Cat;
import pro.sky.telegrambot.repository.CatRepository;

@Service
public class CatService {
    Logger logger = LoggerFactory.getLogger(CatService.class);
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat createCat(Cat cat) {
        logger.info("Method createCat was invoked");
        return catRepository.save(cat);
    }

    public Cat getCat(Long id) {
        logger.info("Method getCat was invoked");
        return catRepository.findById(id).orElse(null);
    }
}
