package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;

import java.io.IOException;

public class Help implements Function{

    private CommunicationHandler communicationHandler;

    public Help(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
    }

    @Override
    public boolean run() throws IOException {
        System.out.println("This are the available commands: \n" +
                "ADD - adds a new task \n" +
                "DEL - deletes a task \n" +
                "DONE - completes a task \n" +
                "LST - list all tasks \n" +
                "LOAD - load tasks \n" +
                "SAVE  saves the tasks file \n" +
                "EXIT - exits the app \n");
        return true;
    }
}
