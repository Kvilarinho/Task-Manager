package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.taskmanager.TaskManager.DOC_ROOT;

public class Done implements Function {

    private CommunicationHandler communicationHandler;
    private File taskFile;

    public Done(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
        this.taskFile = new File(DOC_ROOT);
    }

    @Override
    public boolean run() throws IOException {

        String tasks = new Lst(communicationHandler).list();
        String[] taskArray = tasks.split(System.lineSeparator());
        List<String> taskList = new ArrayList<>(Arrays.asList(taskArray));
        System.out.println("What's the task you completed? ID: ");
        int id = Integer.parseInt(communicationHandler.readTask());
        String target = String.valueOf(id);
        int index = -1;
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).contains(target)) {
                index = i;
                break;
            }
        }
        String task = taskList.get(index).replace("[ ]", "[X]");
        taskList.remove(index);
        taskList.add(index, task);
        String newList = String.join(System.lineSeparator(), taskList);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFile))) {
            writer.write(newList);
            System.out.println("OK");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("NOT FOUND");
        }
        return true;
    }




    /*
    DONE <id>
    Marca tarefa como concluída.
    Resposta: OK ou NOT_FOUND
     */
}
