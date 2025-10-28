package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;

/**
 * Handles the "EXIT" command of the Task Manager.
 * <p>
 * Prints a goodbye message and stops the main application loop.
 * </p>
 */
public class Exit extends Commands implements Function {

    /**
     * Creates a new Exit command instance.
     *
     * @param communicationHandler the communication handler used for user interaction
     */
    public Exit(CommunicationHandler communicationHandler) {
        super(communicationHandler);
    }

    /**
     * Executes the "EXIT" command.
     * <ul>
     *   <li>Displays a goodbye message</li>
     *   <li>Returns {@code false} to stop the main loop</li>
     * </ul>
     *
     * @return {@code false} to terminate the program
     */
    @Override
    public boolean run() {
        System.out.println("Bye");
        return false;
    }
}
