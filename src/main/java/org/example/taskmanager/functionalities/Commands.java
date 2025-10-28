package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;
import java.io.File;

import static org.example.taskmanager.TaskManager.TASK_FILE;

/**
 * Base class for all command implementations.
 * <p>
 * Provides shared access to the {@link CommunicationHandler}
 * and the task file used for persistence.
 * </p>
 */
public abstract class Commands {

    /** Handles input communication with the user. */
    protected CommunicationHandler communicationHandler;

    /** Reference to the task file used for storing tasks. */
    protected File taskFile;

    /**
     * Creates a new command base instance.
     *
     * @param communicationHandler the communication handler for user interaction
     */
    public Commands(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
        this.taskFile = new File(TASK_FILE);
    }
}
