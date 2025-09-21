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

public class ListHandler extends Commands {

    public ListHandler(CommunicationHandler communicationHandler) {
        super(communicationHandler);
    }

    public List<String> getTaskList() throws IOException {
        String tasks = new Lst(communicationHandler).list();
        String[] taskArray = tasks.split(System.lineSeparator());
        List<String> taskList = new ArrayList<>(Arrays.asList(taskArray));
        return taskList;
    }

    public int getId() throws IOException {
        return Integer.parseInt(communicationHandler.readTask());
    }

    public int findTask(List<String> taskList, int id) {
        String target = String.valueOf(id);
        int index = -1;
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).startsWith("[ ] id: " + target)
                    || taskList.get(i).startsWith("[X] id: " + target) ) {
                index = i;
                break;
            }
        }
        return index;
    }

    public List<String> removeTask(List<String> tasklist, int index) {
        tasklist.remove(index);
        return tasklist;
    }

    public List<String> completeTask(List<String> taskList, int index) {
        String task = taskList.get(index).replace("[ ]", "[X]");
        removeTask(taskList, index);
        taskList.add(index, task);
        return taskList;
    }

    public void writeFile(List<String> taskList) throws IOException {
        String newList = String.join(System.lineSeparator(), taskList);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFile))) {
            writer.write(newList + System.lineSeparator());
            System.out.println("OK");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("NOT FOUND");
        }
    }
}
