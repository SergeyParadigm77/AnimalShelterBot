package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.Volunteer;
@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
