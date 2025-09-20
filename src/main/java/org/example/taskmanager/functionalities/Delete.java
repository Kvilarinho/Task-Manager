package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.taskmanager.TaskManager.DOC_ROOT;

public class Delete implements Function {

    private CommunicationHandler communicationHandler;
    private File taskFile;
    private File idFile;

    public Delete(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
        this.taskFile = new File(DOC_ROOT);
        this.idFile = new File("id.dat");
    }


    @Override
    public boolean run() throws IOException {

        String tasks = new Lst(communicationHandler).list();
        String[] taskArray = tasks.split(System.lineSeparator());
        List<String> taskList = new ArrayList<>(Arrays.asList(taskArray));
        System.out.println("What's the task you wish to remove? ID: ");
        int id = Integer.parseInt(communicationHandler.readTask());
        taskList.remove(id-1);
        String newList = String.join(System.lineSeparator(), taskList);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFile))) {
            writer.write(newList);
            System.out.println("OK");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("NOT FOUND");
        }
        return true;
    }

}
