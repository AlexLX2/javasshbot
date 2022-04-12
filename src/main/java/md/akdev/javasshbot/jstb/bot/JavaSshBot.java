package md.akdev.javasshbot.jstb.bot;

import md.akdev.javasshbot.jstb.command.CommandContainer;
import md.akdev.javasshbot.jstb.service.AssetService;
import md.akdev.javasshbot.jstb.service.PlaybookService;
import md.akdev.javasshbot.jstb.service.SendBotMessageServiceImpl;
import md.akdev.javasshbot.jstb.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static md.akdev.javasshbot.jstb.command.CommandName.NO;

@Component
public class JavaSshBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    private final CommandContainer commandContainer;

    @Autowired
    public JavaSshBot(TelegramUserService telegramUserService, AssetService assetService, PlaybookService playbookService) {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), telegramUserService, assetService, playbookService);
    }

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
        else if (update.hasCallbackQuery()){
            if(update.getCallbackQuery().getData().isBlank())
            commandContainer.retrieveCommand("ASSET_BTN").execute(update);
            else if(update.getCallbackQuery().getData().startsWith("asset")){
                commandContainer.retrieveCommand("COMMAND_BTN").execute(update);
            }
            else if(update.getCallbackQuery().getData().startsWith("command")){
                commandContainer.retrieveCommand("PLAYBOOK").execute(update);
            }
            else {commandContainer.retrieveCommand(NO.getCommandName()).execute(update);}
        }
    }
}
