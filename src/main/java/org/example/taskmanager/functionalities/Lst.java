package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;
import java.io.*;

/**
 * Handles the "LST" command of the Task Manager.
 * <p>
 * Displays all tasks stored in the task file. Also provides a helper
 * method to return the full list as a single formatted string.
 * </p>
 */
public class Lst extends Commands implements Function {

    /**
     * Creates a new Lst command instance.
     *
     * @param communicationHandler the communication handler used for user interaction
     */
    public Lst(CommunicationHandler communicationHandler) {
        super(communicationHandler);
    }

    /**
     * Executes the "LST" command.
     * <ul>
     *   <li>Reads the task file line by line</li>
     *   <li>Prints each task to the console</li>
     * </ul>
     *
     * @return {@code true} to continue running the main loop
     * @throws IOException if an I/O error occurs while reading the file
     */
    @Override
    public boolean run() throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(taskFile))) {
            String tasks;
            while ((tasks = in.readLine()) != null) {
                System.out.println(tasks);
            }
        }
        return true;
    }

    /**
     * Returns all tasks as a single string with line breaks.
     *
     * @return a string containing all tasks from the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public String list() throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(taskFile))) {
            String tasks;
            while ((tasks = in.readLine()) != null) {
                sb.append(tasks);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
