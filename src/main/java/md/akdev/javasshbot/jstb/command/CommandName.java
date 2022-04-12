package md.akdev.javasshbot.jstb.command;

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    ASSETS("/assets"),
    ASSET_LIST("assets"),
    COMMAND_LIST("command"),
    PLAYBOOK("playbook"),
    NO("");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

}
