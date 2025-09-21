package Handlers.Commands;

import Handlers.Commands.Interfaces.Command;

public class EndShiftCommand implements Command {
    @Override
    public String InitMessage() {
        return "Смена закрыта";
    }

    @Override
    public String Action(String message) {
        return "Для открытия смены /startShift";
    }
}
