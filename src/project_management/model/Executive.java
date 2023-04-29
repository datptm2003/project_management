/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.model;

/**
 *
 * @author HCMUT
 */
public class Executive {
    public enum Gender {MALE,FEMALE}
    
    private int id;
    private String name;
    private String personal_id;
    private String date_of_birth;
    private Gender gender;
    private String major;
    private String email;

    public Executive() {
        
    }

    public Executive(int id, String name, String personal_id, String date_of_birth, Gender gender, String major, String email) {
        this.id = id;
        this.name = name;
        this.personal_id = personal_id;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.major = major;
        this.email = email;
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
    public void setMajor(String major) {
        this.major = major;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
