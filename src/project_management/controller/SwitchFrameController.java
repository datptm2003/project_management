/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_management.controller;
import java.util.List;

/**
 *
 * @author HCMUT
 */
public class SwitchFrameController {
    private javax.swing.JPanel jpbView;
    private javax.swing.JLabel jpbTitle;
    private String kindSelected = "";
    private List<project_management.bean.MenuItem> menuList;
    
    public SwitchFrameController(javax.swing.JPanel jpbView, javax.swing.JLabel jpbTitle) {
        this.jpbView = jpbView;
        this.jpbTitle = jpbTitle;
    }
    
    public void setDashboard() {
        jpbTitle.setText("Dashboard");
            
        jpbView.removeAll();
        jpbView.setLayout(new java.awt.BorderLayout());
        jpbView.add(new project_management.view.Dashboard.Dashboard());
        jpbView.validate();
        jpbView.repaint();
    }
    
    public void setEvent(List<project_management.bean.MenuItem> list) {
        this.menuList = list;
        for (project_management.bean.MenuItem item : menuList) {
           item.getJpn().addMouseListener(new LabelEvent(item.getKind(), item.getJpn()));
        }
    }
    
    class LabelEvent implements java.awt.event.MouseListener {
        //private javax.swing.JPanel jpbView = project_management.main.MainFrame.content;

        private javax.swing.JPanel node;
        private String kind;

        private javax.swing.JPanel jpnItem;

        public LabelEvent(String kind, javax.swing.JPanel jpnItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            switch (kind) {
                case "Dashboard":
                    node = new project_management.view.Dashboard.Dashboard();
                    break;
                case "Manage task":
                    node = new project_management.view.TaskManagement.TaskManagement();
                    break;
                case "Manage member":
                    node = new project_management.view.MemberManagement.MemberManagement();
                    break;
                case "Manage team":
                    node = new project_management.view.TeamManagement.TeamManagement();
                    break;
                default:
                    break;
            }
            jpbTitle.setText(kind);
            
            jpbView.removeAll();
            jpbView.setLayout(new java.awt.BorderLayout());
            jpbView.add(node);
            jpbView.validate();
            jpbView.repaint();
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            kindSelected = kind;
            //jpnItem.setBackground(new java.awt.Color(61, 90, 128));
            jpnItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            jpnItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jpnItem.setBackground(new java.awt.Color(61, 90, 128));
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            jpnItem.setBackground(new java.awt.Color(152, 193, 217));
            
        }

    }
}


