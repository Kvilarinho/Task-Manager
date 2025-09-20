package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;
import java.io.*;

import static org.example.taskmanager.TaskManager.DOC_ROOT;


public class Add implements Function {

    private CommunicationHandler communicationHandler;
    private File taskFile;
    private File idFile;
    private int id;

    public Add(CommunicationHandler communicationHandler) {
        this.communicationHandler = communicationHandler;
        this.taskFile = new File(DOC_ROOT);
        this.idFile = new File("id.dat");
        this.id = loadOrDefault();
    }

    private int loadOrDefault() {
        if (idFile.exists() && idFile.isFile()) {
            try (DataInputStream in = new DataInputStream(new FileInputStream(idFile))) {
                return in.readInt();
            } catch (IOException ignore) {}
        }
        return 1;
    }

    private void saveID() throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(idFile))) {
            out.writeInt(id);
            out.flush();
        }
    }

    @Override
    public boolean run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFile,true))) {
            System.out.println("Enter a task: ");
            String task = communicationHandler.readTask();
            writer.write("[ ] " + "id: " + id + " - " + task + "\n");
            System.out.println("OK id: " + id);
            id++;
            saveID();

        } catch (IOException e) {
            System.out.println("Unable to write task " + e.getMessage());
        }
        return true;

    }
}
