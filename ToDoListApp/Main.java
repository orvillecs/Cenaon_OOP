import controller.TaskManager;
import ui.MainAppWindow;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        MainAppWindow ui = new MainAppWindow(manager);
        ui.setVisible(true);
    }
}