
package Business.Airliner.Flight;

import Business.TravelOffice.Customer.Customer;


public class Seat {
    // attribute: seatsType/ row/ colum/ boolean assigned/ assgned to: (customer)
    // getter/setter

    // Enum Type : Window/middle/Asile
    // 
    private String seatType;
    private int row;
    private int colum;
    private boolean assigned;
    // pdf - customer-2 reserved seat
    private boolean reserved;
    private Customer customer;
    
    public enum seatType{
        Window,Middle,Asile;
    }
    
    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColum() {
        return colum;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
}
