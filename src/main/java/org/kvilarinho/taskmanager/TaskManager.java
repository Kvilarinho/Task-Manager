package org.kvilarinho.taskmanager;

import org.kvilarinho.taskmanager.functionalities.*;
import org.kvilarinho.taskmanager.functionalities.utils.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Core controller of the Task Manager CLI.
 * <p>
 * Responsible for coordinating the overall program flow,
 * including command registration, input handling, and
 * interaction between the user and the {@link TaskRepository}.
 * </p>
 *
 * <p><b>Main responsibilities:</b></p>
 * <ul>
 *   <li>Set up user input/output streams</li>
 *   <li>Register and map supported commands</li>
 *   <li>Load tasks from persistent storage at startup</li>
 *   <li>Run the main loop until the user exits</li>
 * </ul>
 *
 * <p><b>Error handling:</b></p>
 * <ul>
 *   <li>Unrecognized commands → displays a suggestion to use HELP</li>
 *   <li>Input/output exceptions → prints a concise error message</li>
 * </ul>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * TaskManager manager = TaskManager.getInstance();
 * manager.init();
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.1
 * @since 1.0
 */
public class TaskManager {

    /** Buffered reader used for console input. */
    private static BufferedReader in;

    /** Flag controlling the main application loop. */
    private boolean running = true;

    /** Map associating each available command with its functionality. */
    private Map<Command, Function> commandMap;

    /** Handles user input and output communication. */
    private CommunicationHandler communicationHandler;

    /** Singleton instance of the TaskManager. */
    private static TaskManager MANAGER_INSTANCE;

    /** Repository responsible for task persistence and in-memory storage. */
    private TaskRepository taskRepository;

    /** Name of the file used for task persistence. */
    public static final String TASK_FILE = "tasks.dat";

    /**
     * Creates a new {@code TaskManager} and initializes its main components.
     * <p>
     * This constructor is private to enforce the Singleton pattern.
     * </p>
     */
    private TaskManager() {
        communicationHandler = new CommunicationHandler();
        commandMap = new HashMap<>();
        taskRepository = TaskRepository.getInstance();
    }

    /**
     * Initializes and starts the Task Manager application.
     * <p>
     * This method:
     * </p>
     * <ul>
     *   <li>Sets up the console input stream</li>
     *   <li>Registers all available commands</li>
     *   <li>Loads tasks from the persistent file</li>
     *   <li>Runs the interactive main loop until "EXIT" is executed</li>
     * </ul>
     *
     * <p>
     * It also handles invalid commands and I/O exceptions gracefully,
     * ensuring the program does not crash on user error.
     * </p>
     */
    public void init() {
        communicationHandler.setIn(setUpStreams());
        setUpCommandMap();
        taskRepository.loadTasksFromRecord();

        System.out.println("Welcome to your Task Manager! Try HELP to see available commands.");

        while (running) {
            System.out.println("Enter a command: ");
            try {
                String message = communicationHandler.readCommand();
                Command command = Command.valueOf(message.trim().toUpperCase());
                Function fn = commandMap.get(command);

                if (fn == null) {
                    System.out.println("Unknown command. Try HELP.");
                    continue;
                }

                running = fn.run();

            } catch (IllegalArgumentException e) {
                System.out.println("Wrong command, try HELP");
            } catch (IOException e) {
                System.out.println("Unable to read command: " + e.getMessage());
            }
        }
    }

    /**
     * Registers all available commands and their implementations.
     * <p>
     * This mapping defines how each CLI command (e.g., ADD, DEL, DONE)
     * is linked to its corresponding class in {@code functionalities}.
     * </p>
     */
    private void setUpCommandMap() {
        commandMap.put(Command.ADD, new Add(communicationHandler, taskRepository));
        commandMap.put(Command.DEL, new Delete(communicationHandler, taskRepository));
        commandMap.put(Command.DONE, new Done(communicationHandler, taskRepository));
        commandMap.put(Command.EXIT, new Exit(communicationHandler, taskRepository));
        commandMap.put(Command.LST, new Lst(communicationHandler, taskRepository));
        commandMap.put(Command.HELP, new Help(communicationHandler, taskRepository));
        commandMap.put(Command.SAVE, new Save(communicationHandler, taskRepository));
    }

    /**
     * Configures the input reader connected to the standard input stream.
     *
     * @return a {@link BufferedReader} used for reading user input
     */
    private BufferedReader setUpStreams() {
        in = new BufferedReader(new InputStreamReader(System.in));
        return in;
    }

    /**
     * Returns the singleton instance of the {@code TaskManager}.
     * <p>
     * If no instance exists, a new one is created.
     * </p>
     *
     * @return the single {@code TaskManager} instance
     */
    public static TaskManager getInstance() {
        if (MANAGER_INSTANCE == null) {
            MANAGER_INSTANCE = new TaskManager();
        }
        return MANAGER_INSTANCE;
    }
}
