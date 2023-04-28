/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.bean;

/**
 *
 * @author HCMUT
 */
public class MenuItem {
    private String kind;
    private javax.swing.JPanel jpn;

    public MenuItem() {
    }

    public MenuItem(String kind, javax.swing.JPanel jpn) {
        this.kind = kind;
        this.jpn = jpn;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public javax.swing.JPanel getJpn() {
        return jpn;
    }

    public void setJpn(javax.swing.JPanel jpn) {
        this.jpn = jpn;
    }

}
