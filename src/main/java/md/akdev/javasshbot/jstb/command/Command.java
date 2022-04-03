package md.akdev.javasshbot.jstb.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    void Execute(Update update);
}
