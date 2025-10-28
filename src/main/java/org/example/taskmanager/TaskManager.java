package org.example.taskmanager;

import org.example.taskmanager.functionalities.*;
import org.example.taskmanager.functionalities.utils.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Core controller of the Task Manager CLI.
 * <p>
 * Sets up input/output, registers available commands,
 * and runs the main loop that reads user commands
 * and delegates them to the correct functionality.
 * </p>
 */
public class TaskManager {

    private static BufferedReader in;
    private boolean running = true;
    private Map<Command, Function> commandMap;
    private CommunicationHandler communicationHandler;

    /** Name of the file used for task persistence (v1). */
    public static final String TASK_FILE = "tasks.dat";

    /**
     * Creates the task manager and initializes the main components.
     */
    public TaskManager() {
        communicationHandler = new CommunicationHandler();
        commandMap = new HashMap<>();
    }

    /**
     * Initializes the application:
     * <ul>
     *   <li>Sets up the user input stream</li>
     *   <li>Registers all available commands</li>
     *   <li>Runs the main loop until the user exits</li>
     * </ul>
     * <p><b>Error handling:</b></p>
     * <ul>
     *   <li>Invalid commands → prints a hint to use HELP</li>
     *   <li>I/O errors when reading input → prints a simple message</li>
     * </ul>
     */
    public void init() {
        communicationHandler.setIn(setUpStreams());
        setUpCommandMap();

        while (running) {
            System.out.println("Enter a command: ");
            try {
                String message = communicationHandler.readCommand();
                Command command = Command.valueOf(message);
                running = commandMap.get(command).run();
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong command, try HELP");
            } catch (IOException e) {
                System.out.println("Unable to read command: " + e.getMessage());
            }
        }
    }

    /**
     * Registers the supported commands and their implementations.
     */
    private void setUpCommandMap() {
        commandMap.put(Command.ADD, new Add(communicationHandler));
        commandMap.put(Command.DEL, new Delete(communicationHandler));
        commandMap.put(Command.DONE, new Done(communicationHandler));
        commandMap.put(Command.EXIT, new Exit(communicationHandler));
        commandMap.put(Command.LST, new Lst(communicationHandler));
        commandMap.put(Command.HELP, new Help(communicationHandler));
    }

    /**
     * Sets up the input reader connected to the console (System.in).
     *
     * @return the configured {@link BufferedReader} for user input
     */
    private BufferedReader setUpStreams() {
        in = new BufferedReader(new InputStreamReader(System.in));
        return in;
    }
}
