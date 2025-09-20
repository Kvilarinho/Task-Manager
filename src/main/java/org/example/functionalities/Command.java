package org.example.functionalities;

public enum Command {

    ADD ("adds a new task"),
    DEL ("deletes a task"),
    DONE ("completes a task"),
    EXIT ("exits the app"),
    LIST ("list all tasks"),
    LOAD ("load tasks "),
    SAVE ("saves the tasks file");

    private String description;

    Command(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
