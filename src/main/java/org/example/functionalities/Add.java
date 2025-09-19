package org.example.functionalities;

import org.example.TaskManager;

import java.io.*;

public class Add implements Function {


    @Override
    public void run() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("tasks.txt"),true));
            writer.write("[ ] " + "id" + "- " + TaskManager.getDescription());
            writer.flush();
        } catch (IOException e) {
            System.out.println("Unable to open stream " + e.getMessage());
        }

    }



    /*
    ADD <descrição>
    Adiciona uma nova tarefa (incompleta por defeito).
    Resposta: OK id=<n>
     */
}
