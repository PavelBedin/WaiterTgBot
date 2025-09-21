package Handlers.Commands.Interfaces;

public interface Command {
    String InitMessage();

    String Action(String message);
}
