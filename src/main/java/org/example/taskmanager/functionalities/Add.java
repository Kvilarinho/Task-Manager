package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;
import java.io.*;

/**
 * Handles the "ADD" command of the Task Manager.
 * <p>
 * Prompts the user for a new task description, assigns a unique ID,
 * and writes the task to the task file. The current ID is saved to a
 * separate file to keep it consistent between runs.
 * </p>
 */
public class Add extends Commands implements Function {

    private File idFile;
    private int id;

    /**
     * Creates a new Add command instance.
     *
     * @param communicationHandler the communication handler used for user input
     */
    public Add(CommunicationHandler communicationHandler) {
        super(communicationHandler);
        this.idFile = new File("id.dat");
        this.id = loadOrDefault();
    }

    /**
     * Loads the last used ID from file or returns 1 if not found.
     *
     * @return the last used ID, or 1 if the file does not exist
     */
    private int loadOrDefault() {
        if (idFile.exists() && idFile.isFile()) {
            try (DataInputStream in = new DataInputStream(new FileInputStream(idFile))) {
                return in.readInt();
            } catch (IOException ignore) {}
        }
        return 1;
    }

    /**
     * Saves the current ID value to file for persistence.
     *
     * @throws IOException if an I/O error occurs while writing
     */
    private void saveID() throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(idFile))) {
            out.writeInt(id);
            out.flush();
        }
    }

    /**
     * Executes the "ADD" command.
     * <ul>
     *   <li>Asks the user to enter a new task</li>
     *   <li>Writes it to the task file with a new ID</li>
     *   <li>Updates and saves the ID counter</li>
     * </ul>
     *
     * @return {@code true} to continue running the main loop
     */
    @Override
    public boolean run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFile, true))) {
            System.out.println("Enter a task: ");
            String task = communicationHandler.readTask();
            writer.write("[ ] id: " + id + " - " + task + "\n");
            System.out.println("OK id: " + id);
            id++;
            saveID();
        } catch (IOException e) {
            System.out.println("Unable to write task " + e.getMessage());
        }
        return true;
    }
}
