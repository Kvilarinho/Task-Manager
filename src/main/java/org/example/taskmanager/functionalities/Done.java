package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;
import org.example.taskmanager.functionalities.utils.ListHandler;

import java.io.IOException;
import java.util.List;

public class Done extends Commands implements Function {

    private ListHandler listHandler;

    public Done(CommunicationHandler communicationHandler) {
        super(communicationHandler);
        listHandler = new ListHandler(communicationHandler);
    }

    @Override
    public boolean run() throws IOException {

        List<String> taskList = listHandler.getTaskList();

        System.out.println("What's the task you completed? ID: ");
        int id = listHandler.getId();

        int index = listHandler.findTask(taskList, id);
        if (index <= 0) {
            System.out.println("NOT FOUND");
            return true;
        }

        taskList = listHandler.completeTask(taskList, index);

        listHandler.writeFile(taskList);

        return true;
    }
}
