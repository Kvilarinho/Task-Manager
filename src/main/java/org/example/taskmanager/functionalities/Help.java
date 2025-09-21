package org.example.taskmanager.functionalities;

import org.example.taskmanager.CommunicationHandler;
import org.example.taskmanager.functionalities.utils.Command;

import java.io.IOException;

public class Help extends Commands implements Function{

    public Help(CommunicationHandler communicationHandler) {
        super(communicationHandler);
    }

    @Override
    public boolean run() throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append(">>> AVAILABLE COMMANDS: \n");
        sb.append("------------------------------------------------------\n");

        for (Command command: Command.values()){
            sb.append(">>> ")
                    .append(command.name())
                    .append(" -> ")
                    .append(command.getDescription())
                    .append("\n");
        }

        sb.append("------------------------------------------------------\n");

        System.out.println(sb.toString());

        return true;
    }
}
