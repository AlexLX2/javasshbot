package md.akdev.javasshbot.jstb.bot.service;

import md.akdev.javasshbot.jstb.repo.TelegramUserRepo;
import md.akdev.javasshbot.jstb.repo.entity.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelegramUserServiceImpl implements TelegramUserService{
    private final TelegramUserRepo telegramUserRepo;

    @Autowired
    public TelegramUserServiceImpl(TelegramUserRepo telegramUserRepo) {
        this.telegramUserRepo = telegramUserRepo;
    }

    @Override
    public void save(TelegramUser telegramUser) {
        telegramUserRepo.save(telegramUser);
    }

    @Override
    public Optional<TelegramUser> findByChatId(Long chatId) {
        return telegramUserRepo.findById(chatId);
    }
}
