package org.example.taskmanager.functionalities.utils;

import org.example.taskmanager.CommunicationHandler;
import org.example.taskmanager.functionalities.Commands;
import org.example.taskmanager.functionalities.Lst;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class responsible for handling task list operations.
 * <p>
 * Provides helper methods to read, find, remove, complete, and save tasks.
 * Used by multiple command classes.
 * </p>
 */
public class ListHandler extends Commands {

    /**
     * Creates a new ListHandler instance.
     *
     * @param communicationHandler the communication handler used for input/output
     */
    public ListHandler(CommunicationHandler communicationHandler) {
        super(communicationHandler);
    }

    /**
     * Loads the current list of tasks from the file.
     *
     * @return a list of all tasks as strings
     * @throws IOException if an I/O error occurs while reading
     */
    public List<String> getTaskList() throws IOException {
        String tasks = new Lst(communicationHandler).list();
        String[] taskArray = tasks.split(System.lineSeparator());
        return new ArrayList<>(Arrays.asList(taskArray));
    }

    /**
     * Reads an ID value from user input.
     *
     * @return the task ID entered by the user
     * @throws IOException if an I/O error occurs while reading
     */
    public int getId() throws IOException {
        return Integer.parseInt(communicationHandler.readTask());
    }

    /**
     * Finds the index of a task in the list based on its ID.
     *
     * @param taskList the list of tasks
     * @param id       the ID to search for
     * @return the index of the matching task, or -1 if not found
     */
    public int findTask(List<String> taskList, int id) {
        String target = String.valueOf(id);
        int index = -1;
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).startsWith("[ ] id: " + target)
                    || taskList.get(i).startsWith("[X] id: " + target)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Removes a task from the list by its index.
     *
     * @param taskList the list of tasks
     * @param index    the index of the task to remove
     * @return the updated task list
     */
    public List<String> removeTask(List<String> taskList, int index) {
        taskList.remove(index);
        return taskList;
    }

    /**
     * Marks a task as completed by replacing "[ ]" with "[X]".
     *
     * @param taskList the list of tasks
     * @param index    the index of the task to complete
     * @return the updated task list
     */
    public List<String> completeTask(List<String> taskList, int index) {
        String task = taskList.get(index).replace("[ ]", "[X]");
        removeTask(taskList, index);
        taskList.add(index, task);
        return taskList;
    }

    /**
     * Writes the updated list of tasks to the file.
     *
     * @param taskList the list of tasks to save
     * @throws IOException if an I/O error occurs while writing
     */
    public void writeFile(List<String> taskList) throws IOException {
        String newList = String.join(System.lineSeparator(), taskList);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFile))) {
            writer.write(newList + System.lineSeparator());
            System.out.println("OK");
        }
    }
}
