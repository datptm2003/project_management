/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.model;

/**
 *
 * @author HCMUT
 */
public class Team {
    private int id;
    private String name;
    private String description;
    private int leader_id;
    
    public Team() {
        
    }
    public Team(int id, String name, String description, int leader_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.leader_id = leader_id;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getLeader_id() {
        return leader_id;
    }
    public void setLeader_id(int leader_id) {
        this.leader_id = leader_id;
    }
    
    
}
