/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.controller.MemberController;
import project_management.model.Member;
import project_management.controller.ConnectDBController;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.*;

/**
 *
 * @author HCMUT
 */
public class MemberController {
    private final Connection connection;
    private Statement statement;
    
    public MemberController() {
        connection = new ConnectDBController().getConnection();
        
    }
    
    public boolean isEmpty() {
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM member LIMIT 1";
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
    public Member getMemberById(int member_id) {
        Member member;
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM member WHERE id = " + member_id + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            resultSet.next();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String personal_id = resultSet.getString("personal_id");
            String date_of_birth = resultSet.getString("date_of_birth");
            Member.Gender gender = Member.Gender.valueOf(resultSet.getString("gender"));
            String major = resultSet.getString("major");
            Member.Position position = Member.Position.valueOf(resultSet.getString("position"));
            String email = resultSet.getString("email");
            int team_id = resultSet.getInt("team_id");
                
            member = new Member(id,name,personal_id,date_of_birth,gender,major,position,email,team_id);
            return member;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public ArrayList<Member> getMembersByName(int member_name) {
        ArrayList<Member> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM member WHERE name = " + member_name + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String personal_id = resultSet.getString("personal_id");
                String date_of_birth = resultSet.getString("date_of_birth");
                Member.Gender gender = Member.Gender.valueOf(resultSet.getString("gender"));
                String major = resultSet.getString("major");
                Member.Position position = Member.Position.valueOf(resultSet.getString("position"));
                String email = resultSet.getString("email");
                int team_id = resultSet.getInt("team_id");
                
                list.add(new Member(id,name,personal_id,date_of_birth,gender,major,position,email,team_id));
            }
            
            return list;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public ArrayList<Member> getAllMembers() {
        ArrayList<Member> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM member;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String personal_id = resultSet.getString("personal_id");
                String date_of_birth = resultSet.getString("date_of_birth");
                Member.Gender gender = Member.Gender.valueOf(resultSet.getString("gender"));
                String major = resultSet.getString("major");
                Member.Position position = Member.Position.valueOf(resultSet.getString("position"));
                String email = resultSet.getString("email");
                int team_id = resultSet.getInt("team_id");
                
                list.add(new Member(id,name,personal_id,date_of_birth,gender,major,position,email,team_id));
            }
            
            return list;
        }
        catch (SQLException e) {
            System.out.println(e);
            return null;
        } 
    }
    public int appendMember(Member member) {
        int currentId = -1;
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO member (name,personal_id,date_of_birth,gender,major,position,email) VALUES ('" +
                    member.getName() + "','" + member.getPersonal_id() + "','" + 
                    member.getDate_of_birth() + "','" + member.getGender() + "','" + 
                    member.getMajor() + "','" + member.getPosition() + "','" + member.getEmail() + "');";
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
    public void removeMemberById(int member_id) {
        try {
            statement = connection.createStatement();
            String query = "DELETE FROM member WHERE id = " + member_id + ";";
            statement.executeUpdate(query);
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int editMember(Member member) {
        int currentId = -1;
        try {
            statement = connection.createStatement();
            String query = "UPDATE member SET name='" + member.getName() + 
                    "', personal_id='" + member.getPersonal_id() +
                    "', dath_of_birth='" + member.getDate_of_birth() + 
                    "', gender='" + member.getGender() +
                    "', major='" + member.getMajor() + 
                    "', position='" + member.getPosition() + 
                    "', email='" + member.getEmail() + 
                    "' WHERE id=" + member.getId() + ";";
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
