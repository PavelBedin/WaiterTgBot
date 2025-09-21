package Handlers;

import Handlers.Commands.Interfaces.Command;
import Handlers.Commands.CommandFactory;
import Handlers.Commands.Interfaces.Disposable;

public class BotHandler {
    private Command command;

    public String Handle(String message) {
        if (IsCommand(message)) {
            if (command != null && command instanceof Disposable disposable) {
                disposable.Dispose();
            }
            try {
                command = CommandFactory.GetCommand(message);
                return command.InitMessage();
            } catch (IllegalArgumentException e) {
                return "Команда не найдена";
            }
        }
        try {
            return command.Action(message);
        } catch (Exception e) {
            return "Что-то пошло не так";
        }
    }

    private static boolean IsCommand(String message) {
        return message.startsWith("/");
    }
}
