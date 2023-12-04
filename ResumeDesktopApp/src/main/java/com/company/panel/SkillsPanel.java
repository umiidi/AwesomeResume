package com.company.panel;

import com.company.config.Config;
import entity.Skill;
import entity.UserSkill;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import main.Context;

public class SkillsPanel extends javax.swing.JPanel {

    public SkillsPanel() {
        initComponents();
        fillWindow();
    }

    private void fillWindow() {
        Context.instanceSkillDao().getAll().forEach(item -> cbSkill.addItem(item));
    }
    private List<UserSkill> userSkills;

    private void fillTable() {
        userSkills = Context.instanceUserSkillDao().getAllSkillByUserId(Config.loggedInUser.getId());
        DefaultTableModel model = new DefaultTableModel();
        Vector<Vector> rows = new Vector<>();
        userSkills.forEach(userSkill -> {
            Vector row = new Vector();
            row.add(userSkill.getSkill());
            row.add(userSkill.getPower());
            rows.add(row);
        });
        Vector columnIdentifiers = new Vector(Arrays.asList("Name", "Power"));
        model.setDataVector(rows, columnIdentifiers);
        tblSkills.setModel(model);
    }

    public void fillUserComponents() {
        fillTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSkills = new javax.swing.JPanel();
        SkillsPanel = new javax.swing.JScrollPane();
        tblSkills = new javax.swing.JTable();
        lblSkill = new javax.swing.JLabel();
        txtSkillName = new javax.swing.JTextField();
        lnlPower = new javax.swing.JLabel();
        sliderPower = new javax.swing.JSlider();
        cbSkill = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        tblSkills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        SkillsPanel.setViewportView(tblSkills);

        lblSkill.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblSkill.setText("Skill:");

        txtSkillName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSkillNameActionPerformed(evt);
            }
        });

        lnlPower.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lnlPower.setText("power:");

        sliderPower.setMaximum(10);
        sliderPower.setMinimum(1);
        sliderPower.setValue(1);

        cbSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSkillActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSkillsLayout = new javax.swing.GroupLayout(pnlSkills);
        pnlSkills.setLayout(pnlSkillsLayout);
        pnlSkillsLayout.setHorizontalGroup(
            pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkillsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SkillsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlSkillsLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSkillsLayout.createSequentialGroup()
                        .addComponent(lnlPower)
                        .addGap(18, 18, 18)
                        .addComponent(sliderPower, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(pnlSkillsLayout.createSequentialGroup()
                        .addComponent(lblSkill)
                        .addGap(18, 18, 18)
                        .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSkillName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(18, 18, 18))
        );
        pnlSkillsLayout.setVerticalGroup(
            pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkillsLayout.createSequentialGroup()
                .addGroup(pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSkillsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSkill)
                            .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSkillName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lnlPower)
                            .addComponent(sliderPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlSkillsLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(pnlSkillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SkillsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSkills, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSkills, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSkillNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSkillNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSkillNameActionPerformed

    private void cbSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSkillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSkillActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblSkills.getSelectedRow();
        try {
            UserSkill us = userSkills.get(index);
            Context.instanceUserSkillDao().removeUserSkill(us.getId());
            fillTable();
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Skill skill = null;
        String skillName = txtSkillName.getText();
        if (skillName != null && !skillName.trim().isEmpty()) {
            skill = new Skill(0, skillName);
            Context.instanceSkillDao().addSkill(skill);
        } else {
            skill = (Skill) cbSkill.getSelectedItem();
        }
        int power = sliderPower.getValue();
        UserSkill us = new UserSkill(0, skill, Config.loggedInUser, power);
        Context.instanceUserSkillDao().addUserSkill(us);
        cbSkill.addItem(skill);
        fillTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Skill skill = null;
        String skillName = txtSkillName.getText();
        if (skillName != null && !skillName.trim().isEmpty()) {
            skill = new Skill(0, skillName);
            Context.instanceSkillDao().addSkill(skill);
        } else {
            skill = (Skill) cbSkill.getSelectedItem();
        }
        int power = sliderPower.getValue();
        UserSkill us = userSkills.get(tblSkills.getSelectedRow());
        us.setSkill(skill);
        us.setPower(power);
        Context.instanceUserSkillDao().updateUserSkill(us);
        cbSkill.addItem(skill);
        fillTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SkillsPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Skill> cbSkill;
    private javax.swing.JLabel lblSkill;
    private javax.swing.JLabel lnlPower;
    private javax.swing.JPanel pnlSkills;
    private javax.swing.JSlider sliderPower;
    private javax.swing.JTable tblSkills;
    private javax.swing.JTextField txtSkillName;
    // End of variables declaration//GEN-END:variables
}
