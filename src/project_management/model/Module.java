/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.model;

/**
 *
 * @author HCMUT
 */
public class Module {
    public enum Status {NEW,IN_PROGRESS,POSTPONED,COMPLETED,CANCELLED};
    
    private int id;
    private String name;
    private String description;
    private Status status;
    private int completeness;
    private int executive_id;
    
    public Module() {
        
    }
    public Module(int id, String name, String description, Status status, int completeness, int executive_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.completeness = completeness;
        this.executive_id = executive_id;
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

    public int getExecutive_id() {
        return executive_id;
    }

    public void setExecutive_id(int executive_id) {
        this.executive_id = executive_id;
    }
    
    
}
