package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.Task;
import org.kvilarinho.taskmanager.TaskRepository;

import java.io.IOException;

/**
 * Handles the <b>"ADD"</b> command of the Task Manager.
 * <p>
 * Allows the user to create a new task by providing a description.
 * A unique ID is automatically assigned by the {@link TaskRepository},
 * the task is added to the in-memory collection, and the updated list
 * is saved to file.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Prompt the user to enter a new task description</li>
 *   <li>Generate a new unique task ID</li>
 *   <li>Add the task to the repository</li>
 *   <li>Persist all tasks to file</li>
 * </ul>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * Enter a task:
 * Buy groceries
 * Task added successfully with ID: 3
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.1
 * @since 1.0
 */
public class Add extends Commands implements Function {

    /**
     * Creates a new {@code Add} command instance.
     *
     * @param communicationHandler the communication handler used for user input
     * @param taskRepository       the repository responsible for managing tasks
     */
    public Add(CommunicationHandler communicationHandler, TaskRepository taskRepository) {
        super(communicationHandler, taskRepository);
    }

    /**
     * Executes the <b>"ADD"</b> command.
     * <p>
     * Reads the task description from the user, creates a new {@link Task}
     * with a unique ID, adds it to the repository, and saves the current
     * task list to file.
     * </p>
     *
     * @return {@code true} to continue running the main loop
     */
    @Override
    public boolean run() {
        try {
            System.out.print("Enter a task: ");
            String description = communicationHandler.readTask();

            int id = taskRepository.getNextId();
            tasks.put(id, new Task(id, description, false));
            taskRepository.saveInFile();

            System.out.println("Task added successfully with ID: " + id);

        } catch (IOException e) {
            System.err.println("Error reading task description: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error while adding task: " + e.getMessage());
        }

        return true;
    }
}
