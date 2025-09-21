package Handlers.Commands;

import Handlers.Commands.Helpers.DefaultMessageHelper;
import Handlers.Commands.Interfaces.Command;

public class FinishServiceCommand implements Command {

    @Override
    public String InitMessage() {
        return "Столик обсужен";
    }

    @Override
    public String Action(String message) {
        return DefaultMessageHelper.getHelpMessage();
    }
}
