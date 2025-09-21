package Handlers.Commands;

import Handlers.Commands.Interfaces.Command;

public class StartShiftCommand implements Command {
    @Override
    public String InitMessage() {
        return "Смена начата, для обсуживания столика /serveTable";
    }

    @Override
    public String Action(String message) {
        return "Смена уже начата. Для обсуживания столика /serveTable";
    }
}
