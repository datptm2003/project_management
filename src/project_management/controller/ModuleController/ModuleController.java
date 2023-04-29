/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.controller.ModuleController;

import java.sql.*;
import java.util.ArrayList;
import project_management.controller.ConnectDBController;
import project_management.model.Executive;
import project_management.model.Module;
import project_management.model.Task;

/**
 *
 * @author HCMUT
 */
public class ModuleController {
    private final Connection connection;
    private Statement statement;
    
    public ModuleController() {
        connection = new ConnectDBController().getConnection();
        
    }

    public boolean isEmpty() {
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM module LIMIT 1";
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
    public Module getModuleById(int module_id) {
        Module module;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM module WHERE id = " + module_id + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            Module.Status status = Module.Status.valueOf(resultSet.getString("status"));
            int completeness = resultSet.getInt("completeness");
            int executive_id = resultSet.getInt("executive_id");
                
            module = new Module(id,name,description,status,completeness, executive_id);
            return module;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public ArrayList<Task> getAllTasksById(int module_id_origin) {
        ArrayList<Task> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM task WHERE module_id = " + module_id_origin + ";";
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
    public ArrayList<Module> getModulesByName(int module_name) {
        ArrayList<Module> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM module WHERE name = " + module_name + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Module.Status status = Module.Status.valueOf(resultSet.getString("status"));
                int completeness = resultSet.getInt("completeness");
                int executive_id = resultSet.getInt("executive_id");
                
                list.add(new Module(id,name,description,status,completeness, executive_id));
            }
            
            return list;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public ArrayList<Module> getAllModules() {
        ArrayList<Module> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM module;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                Module.Status status = Module.Status.valueOf(resultSet.getString("status"));
                int completeness = resultSet.getInt("completeness");
                int executive_id = resultSet.getInt("executive_id");
                
                list.add(new Module(id,name,description,status,completeness, executive_id));
            }
            
            return list;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    }
    public int appendModule(Module module) {
        int currentId = -1;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO module (name,description,status,completeness,executive_id) VALUES ('" + 
                    module.getName() + "','" + module.getDescription() + "','" +
                    module.getStatus() + "','" + module.getCompleteness() + "'," +
                    module.getExecutive_id() + ");";
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
    public void removeModuleById(int module_id) {
        try {
            statement = connection.createStatement();
            String query = "DELETE FROM module WHERE id = " + module_id + ";";
            statement.executeUpdate(query);
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int editModule(Module module) {
        int currentId = -1;
        try {
            statement = connection.createStatement();
            String query = "UPDATE module SET name='" + module.getName() + 
                    "', description='" + module.getDescription() + 
                    "', status='" + module.getStatus() + 
                    "', completeness='" + module.getCompleteness() + 
                    "', executive_id='" + module.getExecutive_id() +
                    "' WHERE id=" + module.getId() + ";";
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
    public ArrayList<Executive> getAllExecutives() {
        ArrayList<Executive> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM executive;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String personal_id = resultSet.getString("personal_id");
                String date_of_birth = resultSet.getString("date_of_birth");
                Executive.Gender gender = Executive.Gender.valueOf(resultSet.getString("gender"));
                String major = resultSet.getString("major");
                String email = resultSet.getString("email");
                
                list.add(new Executive(id,name,personal_id,date_of_birth,gender,major,email));
            }
            
            return list;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    }
}
