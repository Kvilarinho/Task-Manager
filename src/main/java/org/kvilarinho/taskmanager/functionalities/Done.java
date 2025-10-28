package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.functionalities.utils.ListHandler;

import java.io.IOException;
import java.util.List;

/**
 * Handles the "DONE" command of the Task Manager.
 * <p>
 * Prompts the user for a task ID and marks the corresponding task
 * as completed if it exists in the task list.
 * </p>
 */
public class Done extends Commands implements Function {

    private ListHandler listHandler;

    /**
     * Creates a new Done command instance.
     *
     * @param communicationHandler the communication handler used for user input
     */
    public Done(CommunicationHandler communicationHandler) {
        super(communicationHandler);
        listHandler = new ListHandler(communicationHandler);
    }

    /**
     * Executes the "DONE" command.
     * <ul>
     *   <li>Asks the user for the ID of the completed task</li>
     *   <li>Searches for the matching task</li>
     *   <li>Marks it as done and updates the task file</li>
     * </ul>
     *
     * @return {@code true} to continue running the main loop
     * @throws IOException if an I/O error occurs while reading or writing
     */
    @Override
    public boolean run() throws IOException {

        List<String> taskList = listHandler.getTaskList();

        System.out.println("What's the task you completed? ID: ");
        int id = listHandler.getId();

        int index = listHandler.findTask(taskList, id);
        if (index < 0) {  // fixed from <= 0
            System.out.println("NOT FOUND");
            return true;
        }

        taskList = listHandler.completeTask(taskList, index);
        listHandler.writeFile(taskList);

        return true;
    }
}
