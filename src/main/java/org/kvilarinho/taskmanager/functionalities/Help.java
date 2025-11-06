package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.TaskRepository;
import org.kvilarinho.taskmanager.functionalities.utils.Command;

/**
 * Handles the <b>"HELP"</b> command of the Task Manager.
 * <p>
 * Displays all available commands along with their descriptions,
 * helping the user understand the application's capabilities.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>List all supported commands</li>
 *   <li>Show a brief description for each command</li>
 *   <li>Provide a clear reference guide for the user</li>
 * </ul>
 *
 * <p><b>Example output:</b></p>
 * <pre>{@code
 * >>> AVAILABLE COMMANDS:
 * ------------------------------------------------------
 * >>> ADD  -> Add a new task to the list
 * >>> LST  -> List all current tasks
 * >>> DONE -> Mark a task as completed
 * >>> DEL  -> Delete a task by ID
 * >>> SAVE -> Save all tasks to file
 * >>> EXIT -> Exit the application
 * ------------------------------------------------------
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.1
 * @since 1.0
 */
public class Help extends Commands implements Function {

    /**
     * Creates a new {@code Help} command instance.
     *
     * @param communicationHandler the communication handler used for user interaction
     * @param taskRepository       the repository providing access to the current task data
     */
    public Help(CommunicationHandler communicationHandler, TaskRepository taskRepository) {
        super(communicationHandler, taskRepository);
    }

    /**
     * Executes the <b>"HELP"</b> command.
     * <p>
     * Iterates over all {@link Command} values and prints their names
     * and corresponding descriptions to the console.
     * </p>
     *
     * @return {@code true} to continue running the main loop
     */
    @Override
    public boolean run() {
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

        System.out.println(sb);
        return true;
    }
}
