package org.kvilarinho.taskmanager;

/**
 * Represents a single task in the Task Manager application.
 * <p>
 * Each task has a unique identifier, a textual description,
 * and a completion status flag.
 * </p>
 *
 * <p><b>Responsibilities:</b></p>
 * <ul>
 *   <li>Store task information (ID, description, and status)</li>
 *   <li>Provide a formatted string representation for persistence</li>
 *   <li>Expose getters and setters for controlled access</li>
 * </ul>
 *
 * <p><b>Example record format:</b></p>
 * <pre>{@code
 * [x] id: 1 - Buy milk
 * [ ] id: 2 - Finish assignment
 * }</pre>
 *
 * @author Kátia Vilarinho
 * @version 1.1
 * @since 1.0
 */
public class Task {

    /** Unique identifier for this task. */
    private int id;

    /** Short text describing the task. */
    private String description;

    /** Completion status flag. {@code true} if the task is done. */
    private boolean done;

    /**
     * Creates a new task instance with the given attributes.
     *
     * @param id          the unique identifier of the task
     * @param description the textual description of the task
     * @param done        {@code true} if the task is completed, {@code false} otherwise
     */
    public Task(int id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    /**
     * Returns the formatted completion identifier.
     * <p>
     * Used internally to represent the task status as
     * {@code "[x]"} for completed or {@code "[ ]"} for pending.
     * </p>
     *
     * @return {@code "[x]"} if done, otherwise {@code "[ ]"}
     */
    private String doneIdentifier() {
        return done ? "[x]" : "[ ]";
    }

    /**
     * Converts this task into a formatted record line for file storage.
     *
     * @return the formatted task string (e.g. {@code "[x] id: 1 - Buy milk"})
     */
    public String toRecord() {
        return doneIdentifier() + " id: " + id + " - " + description;
    }

    /**
     * Returns the task ID.
     *
     * @return the task identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the task description.
     *
     * @return the task description text
     */
    public String getDescription() {
        return description;
    }

    /**
     * Updates the task description.
     *
     * @param description the new description text
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns whether the task is completed.
     *
     * @return {@code true} if the task is done, {@code false} otherwise
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Sets the completion status of the task.
     *
     * @param done {@code true} to mark as completed, {@code false} to mark as pending
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * Returns a human-readable string representation of this task.
     * <p>
     * Equivalent to {@link #toRecord()}.
     * </p>
     *
     * @return the formatted task string
     */
    @Override
    public String toString() {
        return toRecord();
    }
}
