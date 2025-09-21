package Handlers.Commands;

import Handlers.Commands.Interfaces.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, Command> dictionary = new HashMap<>() {{
        put("/start", new StartCommand());
        put("/help", new HelpCommand());
        put("/startShift", new StartShiftCommand());
        put("/endShift", new EndShiftCommand());
        put("/serveTable", new ServeTableCommand());
        put("/finishService", new FinishServiceCommand());
    }};


    public static Command GetCommand(String command) {
        Command cmd = dictionary.get(command);
        if (cmd == null) {
            throw new IllegalArgumentException();
        }
        return cmd;
    }
}
