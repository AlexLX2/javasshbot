package md.akdev.javasshbot.jstb.command;

import com.google.common.collect.ImmutableMap;
import md.akdev.javasshbot.jstb.service.AssetService;
import md.akdev.javasshbot.jstb.service.PlaybookService;
import md.akdev.javasshbot.jstb.service.SendBotMessageService;
import md.akdev.javasshbot.jstb.service.TelegramUserService;

import static md.akdev.javasshbot.jstb.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService, AssetService assetService, PlaybookService playbookService) {

        commandMap = ImmutableMap.<String,Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(ASSETS.getCommandName(), new AssetCommand(sendBotMessageService, assetService))
                .put("ASSET_BTN", new AssetListCommand(sendBotMessageService, telegramUserService, assetService, playbookService))
                .put("COMMAND_BTN", new CommandListCommand(sendBotMessageService, telegramUserService, assetService, playbookService))
                .put("PLAYBOOK", new PlaybookCommand(sendBotMessageService, telegramUserService, assetService, playbookService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
