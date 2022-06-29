package md.akdev.javasshbot.jstb.bot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message);
    void sendKeyboard(String chatId, String message, InlineKeyboardMarkup markupInline);
}
