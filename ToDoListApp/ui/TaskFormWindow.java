package ui;

import controller.TaskManager;
import model.Task;
import javax.swing.*;
import java.awt.*;

public class TaskFormWindow extends JFrame {
    private JTextField txtId, txtName;
    private JTextArea txtDesc;
    private JComboBox<String> cmbStatus;
    private TaskManager manager;
    private MainAppWindow parent;

    public TaskFormWindow(TaskManager manager, MainAppWindow parent) {
        this.manager = manager;
        this.parent = parent;
        setTitle("Add New Task");
        setSize(300, 400);
        setLayout(new GridLayout(6, 1));

        txtId = new JTextField("ID-" + (manager.getTaskCount() + 1));
        txtId.setEditable(false);

        txtName = new JTextField();
        txtDesc = new JTextArea(3, 20);
        
        cmbStatus = new JComboBox<>(new String[]{"Not Started", "Ongoing", "Completed"});

        JButton btnSave = new JButton("Save Task");
        btnSave.addActionListener(e -> saveTask());

        add(new JLabel("Task ID:")); add(txtId);
        add(new JLabel("Task Name:")); add(txtName);
        add(new JLabel("Description:")); add(new JScrollPane(txtDesc));
        add(new JLabel("Status:")); add(cmbStatus);
        add(btnSave);
    }

    private void saveTask() {
    	// inside saveTask() method
    	if (txtName.getText().trim().isEmpty() || txtDesc.getText().trim().isEmpty()) {
    	    // This matches the "Input Error" dialog shown in the PDF image
    	    JOptionPane.showMessageDialog(this, 
    	        "Please fill in Task Name and Description.", 
    	        "Input Error", 
    	        JOptionPane.ERROR_MESSAGE);
    	    return;
    	}
        
        

        Task newTask = new Task(txtId.getText(), txtName.getText(), txtDesc.getText(), cmbStatus.getSelectedItem().toString());
        manager.addTask(newTask);
        parent.refreshTable();
        this.dispose();
    }
}