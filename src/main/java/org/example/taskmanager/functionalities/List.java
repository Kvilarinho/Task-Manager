package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;

import java.io.*;

import static org.example.taskmanager.TaskManager.DOC_ROOT;

public class List implements Function {

    private CommunicationHandler communicationHandler;
    private File taskFile;

    public List(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
        this.taskFile = new File(DOC_ROOT);
    }

    @Override
    public boolean run() throws IOException {

        try (BufferedReader in = new BufferedReader(new FileReader(taskFile))) {
            String tasks;
            while ((tasks = in.readLine()) != null) {
                System.out.println(tasks);
            }
        }
        return true;
    }

    /*
    Lista todas as tarefas no formato:

    [ ] 1 - Comprar leite
    [x] 2 - Estudar sockets
    [ ] 3 - Escrever resumo


    [ ] → incompleta, [x] → completa
     */
}
