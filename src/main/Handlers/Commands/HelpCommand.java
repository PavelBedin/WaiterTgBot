package Handlers.Commands;

import Handlers.Commands.Helpers.DefaultMessageHelper;
import Handlers.Commands.Interfaces.Command;

public class HelpCommand implements Command {
    @Override
    public String InitMessage() {
        return DefaultMessageHelper.getHelpMessage();
    }

    @Override
    public String Action(String message) {
        return DefaultMessageHelper.getHelpMessage();
    }
}
