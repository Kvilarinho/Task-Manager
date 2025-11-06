package org.kvilarinho.taskmanager.functionalities;

import org.kvilarinho.taskmanager.CommunicationHandler;
import org.kvilarinho.taskmanager.Task;
import org.kvilarinho.taskmanager.TaskRepository;

import java.util.Map;

/**
 * Abstract base class for all command implementations in the Task Manager.
 * <p>
 * Provides shared access to key application components required by all
 * command classes, including the {@link CommunicationHandler} for user
 * interaction and the {@link TaskRepository} for data persistence.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Expose a consistent interface to the communication handler</li>
 *   <li>Provide shared access to the in-memory {@code tasks} map</li>
 *   <li>Maintain a reference to the {@link TaskRepository} for persistence operations</li>
 *   <li>Serve as the superclass for all functional command classes (e.g. ADD, DEL, DONE)</li>
 * </ul>
 *
 * <p><b>Example subclass:</b></p>
 * <pre>{@code
 * public class Lst extends Commands implements Function {
 *     public Lst(CommunicationHandler handler, TaskRepository repo) {
 *         super(handler, repo);
 *     }
 *
 *     @Override
 *     public boolean run() {
 *         // Command-specific logic
 *         return true;
 *     }
 * }
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.1
 * @since 1.0
 */
public abstract class Commands {

    /** Handles all user input and output interactions. */
    protected final CommunicationHandler communicationHandler;

    /** Live view of tasks managed by the repository (shared reference). */
    protected final Map<Integer, Task> tasks;

    /** Repository responsible for task storage and persistence operations. */
    protected final TaskRepository taskRepository;

    /**
     * Creates a new command base instance.
     *
     * @param communicationHandler the handler responsible for console I/O
     * @param taskRepository       the repository that provides and persists tasks
     */
    public Commands(CommunicationHandler communicationHandler, TaskRepository taskRepository) {
        this.communicationHandler = communicationHandler;
        this.taskRepository = taskRepository;
        this.tasks = taskRepository.getTasks();
    }
}
