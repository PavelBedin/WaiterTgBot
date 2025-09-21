package Handlers.Commands;

import Handlers.Commands.Helpers.DefaultMessageHelper;
import Handlers.Commands.Interfaces.Command;

public class StartCommand implements Command {
    @Override
    public String InitMessage() {
        return DefaultMessageHelper.getHelpMessage();
    }

    @Override
    public String Action(String message) {
        return "Пожалуйста, введите одну из команд. Для помощи вызовите /help";
    }
}
