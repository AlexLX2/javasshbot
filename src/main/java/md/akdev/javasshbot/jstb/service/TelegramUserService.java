package md.akdev.javasshbot.jstb.service;

import md.akdev.javasshbot.jstb.repo.entity.TelegramUser;

import java.util.Optional;

public interface TelegramUserService {
    void save(TelegramUser telegramUser);
    Optional<TelegramUser> findByChatId(Long chatId);
}
