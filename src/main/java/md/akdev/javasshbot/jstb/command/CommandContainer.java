package md.akdev.javasshbot.jstb.command;

import com.google.common.collect.ImmutableMap;
import md.akdev.javasshbot.jstb.bot.service.AssetService;
import md.akdev.javasshbot.jstb.bot.service.PlaybookService;
import md.akdev.javasshbot.jstb.bot.service.SendBotMessageService;
import md.akdev.javasshbot.jstb.bot.service.TelegramUserService;

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
                .put(ASSET_LIST.getCommandName(), new AssetListCommand(sendBotMessageService, telegramUserService, assetService, playbookService))
                .put(COMMAND_LIST.getCommandName(), new CommandListCommand(sendBotMessageService, telegramUserService, assetService, playbookService))
                .put(PLAYBOOK.getCommandName(), new PlaybookCommand(sendBotMessageService, telegramUserService, assetService, playbookService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
