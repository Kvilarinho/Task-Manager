package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;

public class Exit implements Function {

    private CommunicationHandler communicationHandler;

    public Exit(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
    }

    @Override
    public boolean run() {

        return false;

    }


}
