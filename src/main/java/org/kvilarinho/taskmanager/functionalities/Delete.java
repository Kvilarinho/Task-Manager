package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.TaskRepository;

/**
 * Handles the <b>"DEL"</b> command of the Task Manager.
 * <p>
 * Removes a specific task from the task list based on its ID.
 * The command asks the user for a task ID, verifies if it exists,
 * removes it from the in-memory collection, and saves the updated list to file.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Prompt the user for the task ID to delete</li>
 *   <li>Validate that the ID exists in the task map</li>
 *   <li>Remove the corresponding task if found</li>
 *   <li>Persist the updated list to file</li>
 * </ul>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * What's the task you wish to remove? ID: 3
 * Task 3 removed successfully
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.1
 * @since 1.0
 */
public class Delete extends Commands implements Function {

    /**
     * Creates a new {@code Delete} command instance.
     *
     * @param communicationHandler the communication handler used for user input
     * @param taskRepository       the repository responsible for task storage and persistence
     */
    public Delete(CommunicationHandler communicationHandler, TaskRepository taskRepository) {
        super(communicationHandler, taskRepository);
    }

    /**
     * Executes the <b>"DEL"</b> command.
     * <p>
     * Reads the task ID from user input, checks if it exists in memory,
     * removes it if found, and saves the updated list to file.
     * Provides feedback messages for invalid or missing IDs.
     * </p>
     *
     * @return {@code true} to continue running the main loop
     */
    @Override
    public boolean run() {
        System.out.print("What's the task you wish to remove? ID: ");

        try {
            int id = Integer.parseInt(communicationHandler.readTask());

            if (!tasks.containsKey(id)) {
                System.out.println("Task not found. Try again.");
                return true;
            }

            tasks.remove(id);
            taskRepository.saveInFile();
            System.out.println("Task " + id + " removed successfully");

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a number.");
        } catch (Exception e) {
            System.err.println("Error while removing task: " + e.getMessage());
        }

        return true;
    }
}
