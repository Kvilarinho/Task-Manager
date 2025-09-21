package org.example.taskmanager.functionalities.utils;

public enum Command {

    ADD ("adds a new task"),
    DEL ("deletes a task"),
    DONE ("completes a task"),
    EXIT ("exits the app"),
    LST ("list all tasks"),
    HELP ("lists all commands");

    private String description;

    Command(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
