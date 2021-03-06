package md.akdev.javasshbot.jstb.command;

import md.akdev.javasshbot.jstb.repo.entity.Asset;
import md.akdev.javasshbot.jstb.bot.service.AssetService;
import md.akdev.javasshbot.jstb.bot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class AssetCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final AssetService assetService;

    public AssetCommand(SendBotMessageService sendBotMessageService, AssetService assetService) {
        this.sendBotMessageService = sendBotMessageService;
        this.assetService = assetService;
    }

    @Override
    public void execute(Update update) {
        List<Asset> assetList= assetService.findAll();

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        for (Asset asset:assetList
             ) {
            List<InlineKeyboardButton> rowInline = new ArrayList<>();
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setCallbackData("asset " + asset.getId());
            inlineKeyboardButton.setText(asset.getName() + " " + asset.getIp());
            rowInline.add(inlineKeyboardButton);
            // Set the keyboard to the markup
            rowsInline.add(rowInline);

        }
        // Add it to the message
        markupInline.setKeyboard(rowsInline);

        sendBotMessageService.sendKeyboard(update.getMessage().getChatId().toString(),"Asset list:", markupInline);
    }
}
