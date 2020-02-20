
package UserInterface.Airliner;

import Business.Airliner.Airliner;
import Business.Ticket.Ticket;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jiyuwan
 */
public class ViewOrderedTicketsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewOrderedTicketsJPanel
     */
    private JPanel cardSequenceJPanel;
    private Airliner airliner;
    public ViewOrderedTicketsJPanel(JPanel cardSequenceJPanel,Airliner airliner) {
        initComponents();
        this.cardSequenceJPanel = cardSequenceJPanel;
        this.airliner = airliner;
        populate();
    }
    
    private void populate(){
        DefaultTableModel dtm = (DefaultTableModel)this.ticketJTable.getModel();
        dtm.setRowCount(0);     
        airliner.getOrderedTicketList().forEach((Ticket ticket)->{
            Object[] row = new Object[ticketJTable.getColumnCount()];
            row[0] = ticket;
            row[1] = ticket.getFlightNumber();
            row[2] = ticket.getSeatInfo();
            row[3] = ticket.getFlight().getDate();
            row[4] = ticket.getAirplaneInfo();
            row[5] = ticket.getCustomerInfo();
            row[6] = ticket.isPending();
                    
            dtm.addRow(row);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ticketJTable = new javax.swing.JTable();

        ticketJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ticket #", "Flight", "Seat #", "Date", "Airliner", "Customer", "Pending"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ticketJTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ticketJTable;
    // End of variables declaration//GEN-END:variables
}