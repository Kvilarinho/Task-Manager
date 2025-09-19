package org.example;

public class Commands {

    private Commands() {};

    public static void sendCommandsList() {
        System.out.println("This are the available commands: \n" +
                "ADD - adds a new task \n" +
                "DEL - deletes a task \n" +
                "DONE - completes a task \n" +
                "LIST - list all tasks \n" +
                "LOAD - load tasks \n" +
                "SAVE  saves the tasks file \n" +
                "EXIT - exits the app \n");
    }
}
