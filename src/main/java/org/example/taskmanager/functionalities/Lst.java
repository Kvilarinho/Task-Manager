package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;
import java.io.*;


public class Lst extends Commands implements Function {


    public Lst(CommunicationHandler communicationHandler) {
        super(communicationHandler);
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

    public String list() throws IOException {

        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(taskFile))) {
            String tasks;
            while ((tasks = in.readLine()) != null) {
                sb.append(tasks);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
