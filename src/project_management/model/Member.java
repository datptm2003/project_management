/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.model;
import java.util.Date;

/**
 *
 * @author HCMUT
 */
public class Member {
    public enum Gender {MALE,FEMALE}
    public enum Position {MEMBER,LEADER};
    
    private int id;
    private String name;
    private String personal_id;
    private String date_of_birth;
    private Gender gender;
    private String major;
    private Position position;
    private String email;
    private int team_id;
    
    public Member() {
        
    }    
    public Member(int id, String name, String personal_id, String date_of_birth, Gender gender, String major, Position position, String email, int team_id) {
        this.id = id;
        this.name = name;
        this.personal_id = personal_id;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.major = major;
        this.position = position;
        this.email = email;
        this.team_id = team_id;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPersonal_id() {
        return personal_id;
    }
    public void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }
    public String getDate_of_birth() {
        return date_of_birth;
    }
    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String hometown) {
        this.major = hometown;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getTeam_id() {
        return team_id;
    }
    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }
    
    
}
