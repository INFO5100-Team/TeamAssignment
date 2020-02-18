
package UserInterface.TravelAgency;

import Business.Airliner.Airliner;
import Business.TravelAgency.TravelAgency;
import Business.TravelOffice.TravelOffice;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author keshav
 */
public class ManageTravelOfficeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageTravelOfficeJPanel
     */
    private TravelAgency travelAgency;
    private JPanel cardSequenceJPanel;
    public ManageTravelOfficeJPanel(TravelAgency travelAgency, JPanel cardSequenceJPanel) {
        initComponents();
        this.travelAgency = travelAgency;
        this.cardSequenceJPanel = cardSequenceJPanel;
        populate();
    }
    public void populate(){
        List<TravelOffice> travelOfficeList = travelAgency.getTravelOfficeDirectory().getTravelOfficList();
        DefaultTableModel dtm = (DefaultTableModel)travelOffJTable.getModel();
        dtm.setRowCount(0);
        
        for(TravelOffice to : travelOfficeList){
            Object[] row = new Object[travelOffJTable.getColumnCount()];
            row[0] = to;
            row[1] = to.getName();
            row[2] = to.getCustomerDirectory().getCustomerNum();
            row[3] = to.getPendingTicket().size();
            row[4] = to.getTicketDirectory().getTicketList().size();
            
            dtm.addRow(row);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        travelOffJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        viewOffBtn = new javax.swing.JButton();
        newOffBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deleteOffjButton = new javax.swing.JButton();
        backjButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        travelOffJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "index", "name", "customer number", "pending tickets number", "total tickets number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(travelOffJTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 490, 160));

        jLabel1.setText("Manage Offices");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        viewOffBtn.setText("View Office >>");
        viewOffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOffBtnActionPerformed(evt);
            }
        });
        jPanel1.add(viewOffBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        newOffBtn.setText("New Office >>");
        newOffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOffBtnActionPerformed(evt);
            }
        });
        jPanel1.add(newOffBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 150, -1));

        jLabel2.setText("// CardSequenceJPane;");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        jLabel3.setText("// input: travel Agency");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        deleteOffjButton.setText("Delete Office");
        deleteOffjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOffjButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteOffjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 150, -1));

        backjButton.setText("<< back");
        backjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void deleteOffjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOffjButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.travelOffJTable.getSelectedRow();
        if(selectedRow <0){
            JOptionPane.showMessageDialog(null, "Please select a row");
        }else{
            TravelOffice to = (TravelOffice)this.travelOffJTable.getValueAt(selectedRow, 0);
            travelAgency.removeTravelOffice(to);
            populate();
            JOptionPane.showMessageDialog(null, "Delete successfully!");
        }
    }//GEN-LAST:event_deleteOffjButtonActionPerformed

    private void viewOffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOffBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.travelOffJTable.getSelectedRow();
        if(selectedRow <0){
            JOptionPane.showMessageDialog(null, "Please select a row");
        }else{
            TravelOffice travelOffice = (TravelOffice)this.travelOffJTable.getValueAt(selectedRow, 0);
            ViewTravelOfficeJPanel viewTO = new ViewTravelOfficeJPanel(travelOffice, cardSequenceJPanel);
            cardSequenceJPanel.add(viewTO);
            CardLayout layout = (CardLayout)cardSequenceJPanel.getLayout();
            layout.next(cardSequenceJPanel);
        }
        
    }//GEN-LAST:event_viewOffBtnActionPerformed

    private void newOffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOffBtnActionPerformed
        // TODO add your handling code here:
        NewTravelOfficeJPanel newPanel = new NewTravelOfficeJPanel(travelAgency, cardSequenceJPanel);
        cardSequenceJPanel.add(newPanel);
        CardLayout layout = (CardLayout)cardSequenceJPanel.getLayout();
        layout.next(cardSequenceJPanel);
        
    }//GEN-LAST:event_newOffBtnActionPerformed

    private void backjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButtonActionPerformed
        // TODO add your handling code here:
        cardSequenceJPanel.remove(this);
        CardLayout layout = (CardLayout) cardSequenceJPanel.getLayout();
        layout.previous(cardSequenceJPanel);
    }//GEN-LAST:event_backjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton;
    private javax.swing.JButton deleteOffjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newOffBtn;
    private javax.swing.JTable travelOffJTable;
    private javax.swing.JButton viewOffBtn;
    // End of variables declaration//GEN-END:variables
}
