package md.akdev.javasshbot.jstb.command;

import md.akdev.javasshbot.jstb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class InlineCommand implements Command{
    private final SendBotMessageService sendBotMessageService;

    public InlineCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        String call_data = update.getCallbackQuery().getData();
        long message_id = update.getCallbackQuery().getMessage().getMessageId();
        long chat_id = update.getCallbackQuery().getMessage().getChatId();

        String answer = "Callback pressed";
        sendBotMessageService.sendMessage(String.valueOf(chat_id), answer);
    }
}
