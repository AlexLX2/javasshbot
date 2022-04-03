package md.akdev.javasshbot.jstb.repo;

import md.akdev.javasshbot.jstb.repo.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramUserRepo extends JpaRepository<TelegramUser, Long> {
}
