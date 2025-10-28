package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.functionalities.utils.ListHandler;

import java.io.IOException;
import java.util.List;

/**
 * Handles the "DEL" command of the Task Manager.
 * <p>
 * Prompts the user for a task ID and removes the matching task
 * from the task list if it exists.
 * </p>
 */
public class Delete extends Commands implements Function {

    private ListHandler listHandler;

    /**
     * Creates a new Delete command instance.
     *
     * @param communicationHandler the communication handler used for user input
     */
    public Delete(CommunicationHandler communicationHandler) {
        super(communicationHandler);
        listHandler = new ListHandler(communicationHandler);
    }

    /**
     * Executes the "DEL" command.
     * <ul>
     *   <li>Displays a prompt asking for the task ID</li>
     *   <li>Searches for the task in the current list</li>
     *   <li>Removes it if found and updates the file</li>
     * </ul>
     *
     * @return {@code true} to continue running the main loop
     * @throws IOException if an I/O error occurs while reading or writing
     */
    @Override
    public boolean run() throws IOException {

        List<String> taskList = listHandler.getTaskList();

        System.out.println("What's the task you wish to remove? ID: ");
        int id = Integer.parseInt(communicationHandler.readTask());

        int index = listHandler.findTask(taskList, id);
        if (index < 0) {
            System.out.println("NOT FOUND");
            return true;
        }

        taskList = listHandler.removeTask(taskList, index);
        listHandler.writeFile(taskList);

        return true;
    }
}
