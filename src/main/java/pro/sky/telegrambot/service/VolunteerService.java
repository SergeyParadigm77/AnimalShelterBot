package pro.sky.telegrambot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.sky.telegrambot.model.Volunteer;
import pro.sky.telegrambot.repository.VolunteerRepository;

public class VolunteerService {
    Logger logger = LoggerFactory.getLogger(VolunteerService.class);
    private final VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    public Volunteer createVolunteer(Volunteer volunteer) {
        logger.info("Method createVolunteer was invoked");
        return volunteerRepository.save(volunteer);
    }

    public Volunteer getVolunteer(Long id) {
        logger.info("Method getVolunteer was invoked");
        return volunteerRepository.findById(id).orElse(null);
    }
}