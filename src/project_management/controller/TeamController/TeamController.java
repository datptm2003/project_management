/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.controller.TeamController;
import project_management.model.Team;
import project_management.controller.ConnectDBController;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author HCMUT
 */
public class TeamController {
    private final Connection connection;
    private Statement statement;
    
    public TeamController() {
        connection = new ConnectDBController().getConnection();
        
    }

    public boolean isEmpty() {
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM team LIMIT 1";
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
    public Team getTeamById(int team_id) {
        Team team;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM team WHERE id = " + team_id + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            int leader_id = resultSet.getInt("leader_id");
                
            team = new Team(id,name,description,leader_id);
            return team;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public ArrayList<Team> getTeamsByName(int team_name) {
        ArrayList<Team> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM team WHERE name = " + team_name + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int leader_id = resultSet.getInt("leader_id");
                
                list.add(new Team(id,name,description,leader_id));
            }
            
            return list;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public ArrayList<Team> getAllTeams() {
        ArrayList<Team> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM team;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int leader_id = resultSet.getInt("leader_id");
                
                list.add(new Team(id,name,description,leader_id));
            }
            
            return list;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    }
    public int appendTeam(Team team) {
        int currentId = -1;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO team (name,description) VALUES ('" + team.getName() + "','" + team.getDescription() + "');";
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
    public void removeTeamById(int team_id) {
        try {
            statement = connection.createStatement();
            String query = "DELETE FROM team WHERE id = " + team_id + ";";
            statement.executeUpdate(query);
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int editTeam(Team team) {
        int currentId = -1;
        try {
            statement = connection.createStatement();
            String query = "UPDATE team SET name='" + team.getName() + "', description='" + team.getDescription() + "' WHERE id=" + team.getId() + ";";
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
