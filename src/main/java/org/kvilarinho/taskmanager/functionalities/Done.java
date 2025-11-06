package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.Task;
import org.kvilarinho.taskmanager.TaskRepository;

/**
 * Handles the <b>"DONE"</b> command of the Task Manager.
 * <p>
 * Marks a specific task as completed based on its ID.
 * The command prompts the user to provide the task ID,
 * validates the input, updates the corresponding task's
 * status, and saves all tasks to the persistent file.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Prompt the user for a task ID</li>
 *   <li>Find and mark the corresponding task as done</li>
 *   <li>Persist the updated task list to file</li>
 *   <li>Provide user feedback for invalid or repeated operations</li>
 * </ul>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * What's the task you completed? ID: 2
 * Task 2 marked as done
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.1
 * @since 1.0
 */
public class Done extends Commands implements Function {

    /**
     * Creates a new {@code Done} command instance.
     *
     * @param communicationHandler the communication handler used for user input
     * @param taskRepository       the repository responsible for storing and persisting tasks
     */
    public Done(CommunicationHandler communicationHandler, TaskRepository taskRepository) {
        super(communicationHandler, taskRepository);
    }

    /**
     * Executes the <b>"DONE"</b> command.
     * <p>
     * Reads the task ID from user input, verifies its existence,
     * marks it as completed, and saves the updated state to file.
     * If the task does not exist or is already done, displays an
     * appropriate message.
     * </p>
     *
     * @return {@code true} to continue running the main loop
     */
    @Override
    public boolean run() {
        System.out.print("What's the task you completed? ID: ");
        try {
            int id = Integer.parseInt(communicationHandler.readTask());
            Task task = tasks.get(id);

            if (task == null) {
                System.out.println("Task not found, try again.");
                return true;
            }

            if (task.isDone()) {
                System.out.println("Task is already marked as done.");
                return true;
            }

            task.setDone(true);
            taskRepository.saveInFile();
            System.out.println("Task " + id + " marked as done");

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Please enter a number.");
        } catch (Exception e) {
            System.err.println("Error marking task as done: " + e.getMessage());
        }

        return true;
    }
}
