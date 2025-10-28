package org.example.taskmanager.functionalities.utils;

/**
 * Represents all available commands in the Task Manager application.
 * <p>
 * Each command has a short description used by the HELP functionality.
 * </p>
 */
public enum Command {

    ADD ("adds a new task"),
    DEL ("deletes a task"),
    DONE ("completes a task"),
    EXIT ("exits the app"),
    LST ("lists all tasks"),
    HELP ("lists all commands");

    private String description;

    /**
     * Creates a command with the given description.
     *
     * @param description a short explanation of what the command does
     */
    Command(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the command.
     *
     * @return the command description
     */
    public String getDescription() {
        return description;
    }
}
