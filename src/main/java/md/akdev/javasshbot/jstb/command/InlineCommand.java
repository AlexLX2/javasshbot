package md.akdev.javasshbot.jstb.command;

import md.akdev.javasshbot.jstb.repo.entity.Asset;
import md.akdev.javasshbot.jstb.repo.entity.TelegramUser;
import md.akdev.javasshbot.jstb.service.AssetService;
import md.akdev.javasshbot.jstb.service.SendBotMessageService;
import md.akdev.javasshbot.jstb.service.TelegramUserService;
import org.checkerframework.checker.units.qual.A;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class InlineCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;
    private final AssetService assetService;


    public InlineCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService, AssetService assetService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
        this.assetService = assetService;
    }



    @Override
    public void execute(Update update) {
        String call_data = update.getCallbackQuery().getData();
        long message_id = update.getCallbackQuery().getMessage().getMessageId();
        long chat_id = update.getCallbackQuery().getMessage().getChatId();
        Optional<TelegramUser> telegramUser = telegramUserService.findByChatId(chat_id);
        String answer = "";
        if (telegramUser.isEmpty() || !telegramUser.get().isActive()) {
             answer = "not autorized!";
        }
        else {
            Asset asset = assetService.findById(Long.valueOf(call_data)).orElse(new Asset());
            answer = asset.getName();

        }

        sendBotMessageService.sendMessage(String.valueOf(chat_id), answer);
    }
}
