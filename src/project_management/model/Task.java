/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.model;

/**
 *
 * @author HCMUT
 */
public class Task {
    public enum Status {NEW,IN_PROGRESS,POSTPONED,COMPLETED,CANCELLED};
    
    private int id;
    private String name;
    private String description;
    private Status status;
    private int completeness;
    private int module_id;
    private int team_id;
    private int member_id;

    public Task() {
        
    }
    public Task(int id, String name, String description, Status status, int completeness, int module_id, int team_id, int member_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.completeness = completeness;
        this.module_id = module_id;
        this.team_id = team_id;
        this.member_id = member_id;
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
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public int getCompleteness() {
        return completeness;
    }
    public void setCompleteness(int completeness) {
        this.completeness = completeness;
    }
    public int getModule_id() {
        return module_id;
    }
    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }
    public int getTeam_id() {
        return team_id;
    }
    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }
    public int getMember_id() {
        return member_id;
    }
    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }
    
    
}
