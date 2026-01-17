package model;

public abstract class AbstractTask {
    private String taskId;
    private String taskName;
    private String taskDescription;

    public AbstractTask() {}

    public AbstractTask(String taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public String getTaskId() {
		return taskId;
		}
    public void setTaskId(String taskId) {
		this.taskId = taskId;
		}

    public String getTaskName() {
		return taskName;
		}
    public void setTaskName(String taskName) {
		this.taskName = taskName;
		}

    public String getTaskDescription() {
		return taskDescription;
		}
    public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
		}

    public abstract String getStatus();
    public abstract void setStatus(String status);
}