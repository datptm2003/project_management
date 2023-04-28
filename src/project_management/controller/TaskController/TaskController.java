/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.controller.TaskController;

import java.sql.*;
import java.util.ArrayList;
import project_management.controller.ConnectDBController;
import project_management.model.Task;

/**
 *
 * @author HCMUT
 */
public class TaskController {
    private final Connection connection;
    private Statement statement;
    
    public TaskController() {
        connection = new ConnectDBController().getConnection();
        
    }

    public boolean isEmpty() {
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM task LIMIT 1";
            ResultSet resultSet = statement.executeQuery(query);
            
            int count = 0;
            while (resultSet.next()) ++count;
            return (count == 0 ? true : false);
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public Task getTaskById(int task_id) {
        Task task;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM task WHERE id = " + task_id + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            Task.Status status = Task.Status.valueOf(resultSet.getString("status"));
            int completeness = resultSet.getInt("completeness");
            int module_id = resultSet.getInt("module_id");
            int team_id = resultSet.getInt("team_id");
            int member_id = resultSet.getInt("member_id");
                
            task = new Task(id,name,description,status,completeness, module_id,team_id,member_id);
            return task;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public ArrayList<Task> getTasksByName(int team_name) {
        ArrayList<Task> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM task WHERE name = " + team_name + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Task.Status status = Task.Status.valueOf(resultSet.getString("status"));
                int completeness = resultSet.getInt("completeness");
                int module_id = resultSet.getInt("module_id");
                int team_id = resultSet.getInt("team_id");
                int member_id = resultSet.getInt("member_id");
                
                list.add(new Task(id,name,description,status,completeness, module_id,team_id,member_id));
            }
            
            return list;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM task;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Task.Status status = Task.Status.valueOf(resultSet.getString("status"));
                int completeness = resultSet.getInt("completeness");
                int module_id = resultSet.getInt("module_id");
                int team_id = resultSet.getInt("team_id");
                int member_id = resultSet.getInt("member_id");
                
                list.add(new Task(id,name,description,status,completeness, module_id,team_id,member_id));
            }
            
            return list;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    }
    public ArrayList<Task> getAllTasksByModuleId(int id_module) {
        ArrayList<Task> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM task WHERE module_id = " + id_module + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Task.Status status = Task.Status.valueOf(resultSet.getString("status"));
                int completeness = resultSet.getInt("completeness");
                int module_id = resultSet.getInt("module_id");
                int team_id = resultSet.getInt("team_id");
                int member_id = resultSet.getInt("member_id");
                
                list.add(new Task(id,name,description,status,completeness, module_id,team_id,member_id));
            }
            
            return list;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    }
    public int appendTask(Task task) {
        int currentId = -1;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO task (name,description,status,completeness) VALUES ('" + 
                    task.getName() + "','" + task.getDescription() + "','" +
                    task.getStatus() + "','" + task.getCompleteness() + "');";
            statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            
            if (resultSet.next()) {
                currentId = resultSet.getInt(1);
            }
            
            return currentId;
        }
        catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    public void removeTaskById(int task_id) {
        try {
            statement = connection.createStatement();
            String query = "DELETE FROM task WHERE id = " + task_id + ";";
            statement.executeUpdate(query);
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int editTask(Task task) {
        int currentId = -1;
        try {
            statement = connection.createStatement();
            String query = "UPDATE task SET name='" + task.getName() + 
                    "', description='" + task.getDescription() + 
                    "', status='" + task.getStatus() + 
                    "', completeness='" + task.getCompleteness() + 
                    "' WHERE id=" + task.getId() + ";";
            statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            
            if (resultSet.next()) {
                currentId = resultSet.getInt(1);
            }
            
            return currentId;
        }
        catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
}
