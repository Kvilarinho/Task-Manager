package org.example.taskmanager;

import java.io.BufferedReader;
import java.io.IOException;



public class CommunicationHandler {

    private static final String BEGINNING_OF_FILE = "BOF";
    private static final String END_OF_FILE = "EOF";

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
