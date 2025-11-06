package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.TaskRepository;

/**
 * Handles the <b>"EXIT"</b> command of the Task Manager.
 * <p>
 * This command is responsible for gracefully terminating the application.
 * It ensures that all current tasks are saved to file before shutting down,
 * displays a farewell message, and stops the main application loop.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Persist all in-memory tasks to the task file</li>
 *   <li>Display a goodbye message to the user</li>
 *   <li>Signal the main loop to terminate</li>
 * </ul>
 *
 * <p><b>Example output:</b></p>
 * <pre>{@code
 * Bye!
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.1
 * @since 1.0
 */
public class Exit extends Commands implements Function {

    /**
     * Creates a new {@code Exit} command instance.
     *
     * @param communicationHandler the communication handler used for user interaction
     * @param taskRepository       the repository responsible for task persistence
     */
    public Exit(CommunicationHandler communicationHandler, TaskRepository taskRepository) {
        super(communicationHandler, taskRepository);
    }

    /**
     * Executes the <b>"EXIT"</b> command.
     * <p>
     * Attempts to save all current tasks to the file, prints a goodbye message,
     * and returns {@code false} to stop the main program loop.
     * </p>
     *
     * @return {@code false} to terminate the program
     */
    @Override
    public boolean run() {
        try {
            taskRepository.saveInFile();
        } catch (Exception e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }

        System.out.println("Bye!");
        return false;
    }
}
