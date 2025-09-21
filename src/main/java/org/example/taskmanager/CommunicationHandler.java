package org.example.taskmanager;

import java.io.BufferedReader;
import java.io.IOException;



public class CommunicationHandler {

    private BufferedReader in;

    public String readTask() throws IOException {
        return in.readLine();
    }

    public String readCommand() throws IOException {
        return in.readLine().toUpperCase();
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

}
