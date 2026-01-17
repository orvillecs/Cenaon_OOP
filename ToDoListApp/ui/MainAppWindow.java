package ui;

import controller.TaskManager;
import model.Task;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainAppWindow extends JFrame {
    private TaskManager manager;
    private JTable table;
    private DefaultTableModel tableModel;
    private TaskFormWindow formWindow = null;

    public MainAppWindow(TaskManager manager) {
        this.manager = manager;
        setTitle("To-Do List Viewer");
        setSize(700, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JButton btnAdd = new JButton("Add Task");
        btnAdd.addActionListener(e -> openForm());

        String[] columns = {"Task ID", "Task Name", "Task Description", "Status"};
        

        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"Not Started", "Ongoing", "Completed"});
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(statusComboBox));
        
        tableModel.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            
            if (column == 3) {
                String newStatus = (String) tableModel.getValueAt(row, column);
                String taskId = (String) tableModel.getValueAt(row, 0);
                
                for (Task t : manager.getAllTasks()) {
                    if (t.getTaskId().equals(taskId)) {
                        t.setStatus(newStatus);
                        break;
                    }
                }
            }
        });

        add(btnAdd, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void openForm() {
        if (formWindow == null || !formWindow.isVisible()) {
            formWindow = new TaskFormWindow(manager, this);
            formWindow.setVisible(true);
        }
    }

    public void refreshTable() {
        if (table.isEditing()) {
            table.getCellEditor().stopCellEditing();
        }
        
        tableModel.setRowCount(0); 
        for (Task t : manager.getAllTasks()) {
            tableModel.addRow(new Object[]{t.getTaskId(), t.getTaskName(), t.getTaskDescription(), t.getStatus()});
        }
    }
}