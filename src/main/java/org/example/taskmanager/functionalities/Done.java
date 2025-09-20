package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;

public class Done implements Function {

    private CommunicationHandler communicationHandler;

    public Done(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
    }

    @Override
    public boolean run() {

        return true;
    }

    /*
    DONE <id>
    Marca tarefa como concluída.
    Resposta: OK ou NOT_FOUND
     */
}
