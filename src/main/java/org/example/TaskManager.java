package org.example;

import org.example.functionalities.Add;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskManager {

    private BufferedReader in;
    private boolean running = true;
    private String description;


    public TaskManager() {

        Add add = new Add();
        
    }

    public void handleRequests() {
        setUpStreams();
        Commands.sendCommandsList();

        while (running) {
            System.out.println("Enter a command: ");
            try {
                readMessage();
            } catch (IOException e) {
                System.out.println("Unable to read commands: " + e.getMessage());
            }
        }
    }

    private String readMessage() throws IOException {
        return in.readLine();
    }

    private void setUpStreams() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String geDescription() throws IOException {
        String[] message = readMessage().split(" ");
        description = message[1];
        return description;
        
    }
}
