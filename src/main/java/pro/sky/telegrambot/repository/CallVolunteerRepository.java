package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.CallVolunteer;

@Repository
public interface CallVolunteerRepository extends JpaRepository<CallVolunteer, Long> {
}
