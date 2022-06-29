package md.akdev.javasshbot.jstb.command;

import md.akdev.javasshbot.jstb.repo.entity.Asset;
import md.akdev.javasshbot.jstb.repo.entity.Playbook;
import md.akdev.javasshbot.jstb.repo.entity.TelegramUser;
import md.akdev.javasshbot.jstb.bot.service.AssetService;
import md.akdev.javasshbot.jstb.bot.service.PlaybookService;
import md.akdev.javasshbot.jstb.bot.service.SendBotMessageService;
import md.akdev.javasshbot.jstb.bot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AssetListCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;
    private final AssetService assetService;
    private final PlaybookService playbookService;


    public AssetListCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService, AssetService assetService, PlaybookService playbookService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
        this.assetService = assetService;
        this.playbookService = playbookService;
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
            sendBotMessageService.sendMessage(String.valueOf(chat_id), answer);
        }
        else {
            Asset asset = assetService.findById(Long.valueOf(call_data)).orElse(new Asset());
            List<Playbook> playbookList = playbookService.findByAssetTypeId(asset.getAssetType().getId());
            //answer = playbookList.toString();
            //answer = testSSHFunc(asset);
            InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
            for (Playbook playbook:playbookList
            ) {
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
                inlineKeyboardButton.setCallbackData("command " + String.valueOf(playbook.getId()));
                inlineKeyboardButton.setText(playbook.getId() + " " + playbook.getCommand());
                rowInline.add(inlineKeyboardButton);
                // Set the keyboard to the markup
                rowsInline.add(rowInline);

            }
            // Add it to the message
            markupInline.setKeyboard(rowsInline);

            sendBotMessageService.sendKeyboard(String.valueOf(chat_id),"Command list:", markupInline);
        }


    }


}
