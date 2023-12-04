package com.company.panel;

import com.company.config.Config;
import entity.Country;
import entity.User;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import main.Context;

public class DetailsPanel extends javax.swing.JPanel {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public DetailsPanel() {
        initComponents();
        fillWindow();
    }

    private void fillWindow(){
        List<Country> countries = Context.instanceCountryDao().getAll();
        for(Country c: countries){
            cbBirthplace.addItem(c);
            cbNationality.addItem(c);
        }
    }
    
    public void fillUserComponents(){
        txtEmail.setText(Config.loggedInUser.getEmail());
        txtAddress.setText(Config.loggedInUser.getAddress());        
        txtPhone.setText(Config.loggedInUser.getPhone());
        txtBirthdate.setText(sdf.format(Config.loggedInUser.getBirthDate()));
        cbBirthplace.setSelectedItem(Config.loggedInUser.getBirthplace());        
        cbNationality.setSelectedItem(Config.loggedInUser.getNationality());
    }
    
    public User fillUser(User u){
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String address = txtAddress.getText();
        Country birthplace = (Country)cbBirthplace.getSelectedItem();
        Country nationality = (Country) cbNationality.getSelectedItem();
        Date birthdate = null;
        try{
            birthdate = new Date(sdf.parse(txtBirthdate.getText()).getTime()); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
        u.setEmail(email);
        u.setPhone(phone);
        u.setAddress(address);
        u.setBirthDate(birthdate);
        u.setBirthplace(birthplace);
        u.setNationality(nationality);
        return u;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetails = new javax.swing.JPanel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblBirthdate = new javax.swing.JLabel();
        txtBirthdate = new javax.swing.JTextField();
        lblBirthplace = new javax.swing.JLabel();
        cbBirthplace = new javax.swing.JComboBox<>();
        lblNationality = new javax.swing.JLabel();
        cbNationality = new javax.swing.JComboBox<>();

        lblAddress.setText("Address");

        lblPhone.setText("Phone");

        lblEmail.setText("Email");

        lblBirthdate.setText("Birthdate");

        txtBirthdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthdateActionPerformed(evt);
            }
        });

        lblBirthplace.setText("Birthplace");

        cbBirthplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBirthplaceActionPerformed(evt);
            }
        });

        lblNationality.setText("Nationality");

        cbNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNationalityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailsLayout.createSequentialGroup()
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(lblBirthdate))
                        .addGap(760, 760, 760))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailsLayout.createSequentialGroup()
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNationality)
                            .addComponent(lblBirthplace))
                        .addGap(748, 748, 748))))
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(lblPhone))
                .addGap(45, 45, 45)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                        .addComponent(txtPhone)
                        .addComponent(txtBirthdate)
                        .addComponent(txtEmail))
                    .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbNationality, javax.swing.GroupLayout.Alignment.LEADING, 0, 152, Short.MAX_VALUE)
                        .addComponent(cbBirthplace, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthdate)
                    .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthplace)
                    .addComponent(cbBirthplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblNationality))
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBirthdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthdateActionPerformed

    private void cbBirthplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBirthplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBirthplaceActionPerformed

    private void cbNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNationalityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Country> cbBirthplace;
    private javax.swing.JComboBox<Country> cbNationality;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthdate;
    private javax.swing.JLabel lblBirthplace;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthdate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

}
