package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.Task;
import org.kvilarinho.taskmanager.TaskRepository;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Handles the <b>"LST"</b> command of the Task Manager.
 * <p>
 * Displays all tasks currently loaded in memory and formats
 * each one using {@link Task#toRecord()} for presentation.
 * Tasks are displayed in ascending order of their IDs.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Retrieve tasks from the {@link TaskRepository}</li>
 *   <li>Format and display them in the console</li>
 *   <li>Show a message if no tasks exist</li>
 * </ul>
 *
 * <p><b>Example output:</b></p>
 * <pre>{@code
 * [ ] id: 1 - Buy groceries
 * [x] id: 2 - Call mom
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.1
 * @since 1.0
 */
public class Lst extends Commands implements Function {

    /**
     * Creates a new {@code Lst} command instance.
     *
     * @param communicationHandler the handler responsible for user interaction
     * @param taskRepository       the repository providing in-memory tasks
     */
    public Lst(CommunicationHandler communicationHandler, TaskRepository taskRepository) {
        super(communicationHandler, taskRepository);
    }

    /**
     * Executes the <b>"LST"</b> command.
     * <p>
     * If there are tasks in memory, prints them sorted by ID.
     * Otherwise, displays a message indicating that the list is empty.
     * </p>
     *
     * @return {@code true} to keep the main loop running
     */
    @Override
    public boolean run() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
            return true;
        }

        String display = tasks.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(entry -> entry.getValue().toRecord())
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(display);
        return true;
    }
}
