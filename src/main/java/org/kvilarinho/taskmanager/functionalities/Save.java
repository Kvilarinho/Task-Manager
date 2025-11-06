package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.TaskRepository;

/**
 * Handles the "SAVE" command of the Task Manager.
 * <p>
 * Persists all in-memory tasks to the task file.
 * This command is optional since tasks are automatically
 * saved on each modification and before exiting.
 * </p>
 */
public class Save extends Commands implements Function {

    /**
     * Creates a new Save command instance.
     *
     * @param communicationHandler the communication handler used for user interaction
     * @param taskRepository       the repository responsible for task persistence
     */
    public Save(CommunicationHandler communicationHandler, TaskRepository taskRepository) {
        super(communicationHandler, taskRepository);
    }

    /**
     * Executes the "SAVE" command.
     * <ul>
     *   <li>Forces all current tasks to be written to file</li>
     *   <li>Displays a confirmation message</li>
     * </ul>
     *
     * @return {@code true} to continue running the main loop
     */
    @Override
    public boolean run() {
        try {
            taskRepository.saveInFile();
            System.out.println("Tasks saved successfully");
        } catch (Exception e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }

        return true;
    }
}
