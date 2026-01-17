package model;

public class TimedTask extends Task {
    private int estimatedMinutes; // Encapsulated attribute [cite: 65, 66]

    public TimedTask(String taskId, String taskName, String taskDescription, String status, int estimatedMinutes) {
        super(taskId, taskName, taskDescription, status);
        this.estimatedMinutes = estimatedMinutes;
    }

    public int getEstimatedMinutes() { return estimatedMinutes; }
    public void setEstimatedMinutes(int estimatedMinutes) { this.estimatedMinutes = estimatedMinutes; }
}