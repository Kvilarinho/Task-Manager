package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;

public class Exit extends Commands implements Function {

    public Exit(CommunicationHandler communicationHandler) {
        super(communicationHandler);
    }

    @Override
    public boolean run() {

        System.out.println("Bye");
        return false;

    }

}
