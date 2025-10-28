package org.kvilarinho.taskmanager;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Handles input communication for the Task Manager application.
 * <p>
 * Provides methods to read user commands and task descriptions
 * from a {@link BufferedReader} source.
 * </p>
 */
public class CommunicationHandler {

    private BufferedReader in;

    /**
     * Reads a task description from the input.
     *
     * @return the task description entered by the user
     * @throws IOException if an I/O error occurs while reading
     */
    public String readTask() throws IOException {
        return in.readLine().trim();
    }

    /**
     * Reads a command from the input and converts it to uppercase.
     *
     * @return the command entered by the user, in uppercase
     * @throws IOException if an I/O error occurs while reading
     */
    public String readCommand() throws IOException {
        return in.readLine().toUpperCase().trim();
    }

    /**
     * Sets the input source for reading commands and tasks.
     *
     * @param in a {@link BufferedReader} connected to the input stream
     */
    public void setIn(BufferedReader in) {
        this.in = in;
    }

}
