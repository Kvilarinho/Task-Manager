package org.kvilarinho.taskmanager;

/**
 * <p><b>Application Entry Point</b></p>
 *
 * <p>This class serves as the starting point of the Task Manager application.
 * It obtains the singleton instance of {@link TaskManager} and triggers its
 * initialization, starting the main program workflow.</p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *     <li>Initialize the Task Manager application</li>
 *     <li>Delegate control flow to {@link TaskManager}</li>
 * </ul>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * java -jar taskmanager.jar
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.0
 * @since 1.0
 */
public class App {

    /**
     * Launches the Task Manager application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();
        taskManager.init();
    }
}
