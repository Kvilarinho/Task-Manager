package org.kvilarinho.taskmanager;

/**
 * <p><b>Application entry point.</b></p>
 *
 * <p>This class serves as the starting point of the Task Manager application.
 * It creates an instance of {@link TaskManager} and initializes it,
 * launching the main program flow.</p>
 *
 * <p>Execution begins in the {@link #main(String[])} method.</p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *     <li>Start the application lifecycle</li>
 *     <li>Delegate execution to {@code TaskManager}</li>
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
     * Starts the Task Manager application.
     *
     * @param args command-line arguments (not used in this version)
     */
    public static void main(String[] args) {
        new TaskManager().init();
    }
}
