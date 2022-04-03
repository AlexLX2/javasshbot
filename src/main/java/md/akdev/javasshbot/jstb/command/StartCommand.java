package md.akdev.javasshbot.jstb.command;

import md.akdev.javasshbot.jstb.repo.entity.TelegramUser;
import md.akdev.javasshbot.jstb.service.SendBotMessageService;
import md.akdev.javasshbot.jstb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static md.akdev.javasshbot.jstb.command.CommandUtils.getChatId;
import static md.akdev.javasshbot.jstb.command.CommandUtils.getUserName;

public class StartCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Привет. Я AKDEV Telegram Bot. Чтобы работать со мной Вам необходимо разрешение папы. Ждите...";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void Execute(Update update) {
        Long chatId = getChatId(update);
        String userName = getUserName(update);

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(false);
                    telegramUserService.save(user);
                    sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), "Я узнаю тебя, " + user.getUserName() + ", но тебе еще не дали доступа");
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setChatId(chatId);
                    telegramUser.setUserName(userName);
                    telegramUser.setActive(false);
                    telegramUserService.save(telegramUser);
                    sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
                }
        );


    }
}
