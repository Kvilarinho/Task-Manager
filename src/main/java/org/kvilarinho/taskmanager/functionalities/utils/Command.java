package org.kvilarinho.taskmanager.functionalities.utils;

/**
 * Enumeration representing all available commands
 * in the Task Manager application.
 * <p>
 * Each constant corresponds to a user command that can be
 * executed through the CLI, and is associated with a short
 * description used by the {@code HELP} functionality.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Provide a centralized definition of all supported commands</li>
 *   <li>Expose a short description for each command (used by HELP)</li>
 *   <li>Enable type-safe mapping between user input and command logic</li>
 * </ul>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * Command cmd = Command.ADD;
 * System.out.println(cmd.getDescription()); // "adds a new task"
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.1
 * @since 1.0
 */
public enum Command {

    /** Adds a new task to the list. */
    ADD("adds a new task"),

    /** Deletes a task by ID. */
    DEL("deletes a task"),

    /** Marks a task as completed. */
    DONE("completes a task"),

    /** Exits the application gracefully. */
    EXIT("exits the app"),

    /** Lists all tasks currently stored. */
    LST("lists all tasks"),

    /** Displays all available commands and their descriptions. */
    HELP("lists all commands"),

    /** Saves all current tasks to the file manually. */
    SAVE("saves all changes");

    /** Short textual description of the command. */
    private final String description;

    /**
     * Creates a command with the given description.
     *
     * @param description a short explanation of what the command does
     */
    Command(String description) {
        this.description = description;
    }

    /**
     * Returns the description of this command.
     *
     * @return the command description
     */
    public String getDescription() {
        return description;
    }
}
