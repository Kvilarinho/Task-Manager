package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.functionalities.utils.Command;

import java.io.IOException;

/**
 * Handles the "HELP" command of the Task Manager.
 * <p>
 * Displays all available commands and their descriptions.
 * </p>
 */
public class Help extends Commands implements Function {

    /**
     * Creates a new Help command instance.
     *
     * @param communicationHandler the communication handler used for user interaction
     */
    public Help(CommunicationHandler communicationHandler) {
        super(communicationHandler);
    }

    /**
     * Executes the "HELP" command.
     * <ul>
     *   <li>Lists all available commands</li>
     *   <li>Shows each command name with its description</li>
     * </ul>
     *
     * @return {@code true} to continue running the main loop
     * @throws IOException if an I/O error occurs while writing to the console
     */
    @Override
    public boolean run() throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append(">>> AVAILABLE COMMANDS:\n");
        sb.append("------------------------------------------------------\n");

        for (Command command : Command.values()) {
            sb.append(">>> ")
                    .append(command.name())
                    .append(" -> ")
                    .append(command.getDescription())
                    .append("\n");
        }

        sb.append("------------------------------------------------------\n");

        System.out.println(sb.toString());
        return true;
    }
}
