package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;
import java.io.File;

import static org.example.taskmanager.TaskManager.DOC_ROOT;

public abstract class Commands {

    protected CommunicationHandler communicationHandler;
    protected File taskFile;

    public Commands(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
        this.taskFile = new File(DOC_ROOT);
    }
}
