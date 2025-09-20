package org.example.taskmanager;

import org.example.taskmanager.functionalities.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    private static BufferedReader in;
    private boolean running = true;
    private Map<Command, Function> commandMap;
    private CommunicationHandler communicationHandler;
    public final static String DOC_ROOT = "tasks.dat";



    public TaskManager() {

        communicationHandler = new CommunicationHandler();
        commandMap = new HashMap<>();

    }

    public void init() {

        communicationHandler.setIn(setUpStreams());
        setUpCommandMap();
        Commands.sendCommandsList();

        while (running) {
            System.out.println("Enter a command: ");
            try {
                String message = communicationHandler.readCommand();
                Command command = Command.valueOf(message);
                running = commandMap.get(command).run();


            } catch (IOException e) {
                System.out.println("Unable to read commands: " + e.getMessage());
            }
        }
    }

    private void setUpCommandMap() {
        commandMap.put(Command.ADD, new Add(communicationHandler));
        commandMap.put(Command.DEL, new Delete());
        commandMap.put(Command.DONE, new Done());
        commandMap.put(Command.EXIT, new Exit(communicationHandler));
        commandMap.put(Command.LIST, new List(communicationHandler));
        commandMap.put(Command.LOAD, new Load());
        commandMap.put(Command.SAVE, new Save());
    }

    public static String readMessage() throws IOException {
        return in.readLine();
    }

    private BufferedReader setUpStreams() {
        in = new BufferedReader(new InputStreamReader(System.in));
        return in;
    }
    

}
