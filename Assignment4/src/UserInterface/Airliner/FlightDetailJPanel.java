/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Airliner;

import Business.Airliner.Airliner;
import Business.Airliner.Fleet.Airplane;
import Business.Airliner.Fleet.AirplaneDirectory;
import Business.Airliner.Flight.Flight;
import Business.Airliner.Flight.FlightSchedual;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author keshav
 */
public class FlightDetailJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FlightDetailJPanel
     */
    public JPanel cardSequenceJPanel;
    public Flight flight;
    public AirplaneDirectory airplaneList;
    FlightSchedual flightList;
    Airliner airliner;

    FlightDetailJPanel(JPanel cardSequenceJPanel, Flight flight,Airliner airliner) {
        initComponents();
        this.airliner = airliner;
        this.flight = flight;
        this.flightList = airliner.getFlightSchedual();
        this.cardSequenceJPanel = cardSequenceJPanel;
        this.airplaneList = airliner.getAirplaneDirectory();
        flightNoTxt.setText(flight.getFlightNo());
        departureTxt.setText(flight.getDeparture());
        destinationTxt.setText(flight.getDestination());
        dateTxt.setText(flight.getDate());
        
        
 
        priceTxt.setText(String.valueOf(flight.getPrice()));
        airplaneCB.setModel(new DefaultComboBoxModel(this.airliner.getAirplaneDirectory().getAirplaneList().toArray()));
        airplaneCB.setSelectedItem(flight.getAirplane());
        startHour.setText(String.valueOf(flight.getStartTime().getHour()));
        startMin.setText(String.valueOf(flight.getStartTime().getMinute()));
        arriveHour.setText(String.valueOf(flight.getArriveTime().getHour()));
        arriveMin.setText(String.valueOf(flight.getArriveTime().getMinute()));
        
    }

 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        flightNoTxt = new javax.swing.JTextField();
        departureTxt = new javax.swing.JTextField();
        destinationTxt = new javax.swing.JTextField();
        dateTxt = new javax.swing.JTextField();
        priceTxt = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        airplaneCB = new javax.swing.JComboBox<>();
        startHour = new javax.swing.JTextField();
        startMin = new javax.swing.JTextField();
        arriveHour = new javax.swing.JTextField();
        arriveMin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Departure");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabel3.setText("Destination");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel4.setText("Take off Date");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel5.setText("Take off Time");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel6.setText("Arrive Time");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel7.setText("Price($)");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel8.setText("FlightNo.");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel9.setText("Airplane");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        flightNoTxt.setEditable(false);
        flightNoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightNoTxtActionPerformed(evt);
            }
        });
        add(flightNoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 80, -1));

        departureTxt.setEditable(false);
        departureTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departureTxtActionPerformed(evt);
            }
        });
        add(departureTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 80, -1));

        destinationTxt.setEditable(false);
        add(destinationTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 80, -1));

        dateTxt.setEditable(false);
        add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 90, -1));

        priceTxt.setEditable(false);
        add(priceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 80, -1));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        saveBtn.setText("Save");
        saveBtn.setEnabled(false);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        backBtn.setText("<<Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        airplaneCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        airplaneCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airplaneCBActionPerformed(evt);
            }
        });
        add(airplaneCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        startHour.setEditable(false);
        add(startHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 50, -1));

        startMin.setEditable(false);
        add(startMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 40, -1));

        arriveHour.setEditable(false);
        arriveHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arriveHourActionPerformed(evt);
            }
        });
        add(arriveHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 50, -1));

        arriveMin.setEditable(false);
        add(arriveMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 40, -1));

        jLabel1.setText("H");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 30, -1));

        jLabel10.setText("M");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        jLabel11.setText("H");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 30, -1));

        jLabel12.setText("M");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 230, 60, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void flightNoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightNoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flightNoTxtActionPerformed

    private void departureTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departureTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departureTxtActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        cardSequenceJPanel.remove(this);
        CardLayout layout = (CardLayout) cardSequenceJPanel.getLayout();
        Component[] comps = this.cardSequenceJPanel.getComponents();
        for(Component comp : comps){
            if(comp instanceof ManageFlightJPanel){
                ManageFlightJPanel manage = (ManageFlightJPanel)comp;
                manage.populateTable(); 
            }
        }
        layout.previous(cardSequenceJPanel);
    }//GEN-LAST:event_backBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        flightNoTxt.setEditable(true);
        startHour.setEditable(true);
        startHour.setEditable(true);
        arriveHour.setEditable(true);
        arriveMin.setEditable(true);
        dateTxt.setEditable(true);
        departureTxt.setEditable(true);
        destinationTxt.setEditable(true);
        priceTxt.setEditable(true);
        airplaneCB.setEditable(true);
        saveBtn.setEnabled(true);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        flightNoTxt.setEditable(false);
        startHour.setEditable(false);
        startHour.setEditable(false);
        arriveHour.setEditable(false);
        arriveMin.setEditable(false);
        dateTxt.setEditable(false);
        departureTxt.setEditable(false);
        destinationTxt.setEditable(false);
        priceTxt.setEditable(false);
        airplaneCB.setEditable(false);
        //saveBtn.setEnabled(false);
        if(flightNoTxt.getText().equals("")||departureTxt.getText().equals("")||destinationTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Flight Number can't be empty!");
            return;
        }else if(Integer.parseInt(startHour.getText())>24||Integer.parseInt(startHour.getText())<0||Integer.parseInt(startMin.getText())>59||Integer.parseInt(startMin.getText())<0||Integer.parseInt(arriveHour.getText())>24||Integer.parseInt(arriveHour.getText())<0|| Integer.parseInt(arriveMin.getText())>59|| Integer.parseInt(arriveMin.getText())<0){
            JOptionPane.showMessageDialog(null, "Hour and minutes must be the right format");
        }else{
        try{
            Double.parseDouble(priceTxt.getText());
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number of price!");
            return;
        }
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date = dateTxt.getText();
        
        try {
                flight.setDate(sdf.parse(date));
	} catch (ParseException e) {
		JOptionPane.showMessageDialog(null, "Date should be the form of yyyy-MM-dd");
                return;
	}
        flight.setStartTime(LocalTime.of(Integer.parseInt(startHour.getText()), Integer.parseInt(startMin.getText())));
        flight.setArriveTime(LocalTime.of(Integer.parseInt(arriveHour.getText()), Integer.parseInt(arriveMin.getText())));
        flight.setDeparture(departureTxt.getText());
        flight.setDestination(destinationTxt.getText());
        flight.setFlightNo(flightNoTxt.getText());
        flight.setPrice(Double.parseDouble(priceTxt.getText()));
        //Airplane airplane = airplaneList.searchAirplane(airplaneCB.getSelectedItem());
        flight.setAirplane((Airplane)airplaneCB.getSelectedItem());
       
            
            
            JOptionPane.showMessageDialog(null, "Flight has been updated Successfully");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void airplaneCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airplaneCBActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_airplaneCBActionPerformed

    private void arriveHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arriveHourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arriveHourActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> airplaneCB;
    private javax.swing.JTextField arriveHour;
    private javax.swing.JTextField arriveMin;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JTextField departureTxt;
    private javax.swing.JTextField destinationTxt;
    private javax.swing.JTextField flightNoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField startHour;
    private javax.swing.JTextField startMin;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
