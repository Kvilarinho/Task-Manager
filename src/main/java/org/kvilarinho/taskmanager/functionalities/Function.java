package org.kvilarinho.taskmanager.functionalities;

import java.io.IOException;

/**
 * Represents a generic command that can be executed by the Task Manager.
 * <p>
 * Each command must implement the {@link #run()} method, which defines
 * the action performed when the command is called.
 * </p>
 */
public interface Function {

    /**
     * Executes the command logic.
     *
     * @return {@code true} to keep the main loop running, or {@code false} to stop it
     * @throws IOException if an I/O error occurs during execution
     */
    boolean run() throws IOException;
}
