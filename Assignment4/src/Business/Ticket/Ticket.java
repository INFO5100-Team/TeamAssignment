
package Business.Ticket;

import Business.Airliner.Airliner;
import Business.Airliner.Flight.*;
import Business.TravelOffice.Customer.Customer;
import Business.TravelOffice.TravelOffice;


public class Ticket {
    // interact with the flight.seat / flight.seatAssignment
    // interact with customer

    
    private static int count =0;
    
    private Flight flight;
    private Customer customer;
    
    // mark which office book this ticket
    private String ticketNumber;
    private String bookOffice;
    private String seatInfo;
    private boolean pending;
    private String flightNumber;
    
    public Ticket(Flight flight, Customer customer, String seatInfo, String officeCode){

//      flight.SeatAssignment(customer, seatNumber);       
        this.ticketNumber = officeCode + Integer.toString(count ++);
        this.bookOffice = officeCode;
        this.seatInfo = seatInfo;
        this.flight = flight;
        this.customer = customer;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Ticket.count = count;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getBookOffice() {
        return bookOffice;
    }

    public void setBookOffice(String bookOffice) {
        this.bookOffice = bookOffice;
    }

    public String getFlightInfo() {
        return flight.getFlightNo();
    }

    public String getSeatInfo() {
        return seatInfo;
    }

    public String getCustomerInfo() {
        return "Name: " + customer.getName() + "ID: " + customer.getIdentityID();
    }

    public String getAirplaneInfo() {
        return flight.getAirplane().toString();
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public String getFlightNumber() {
        return flight.getFlightNo();
    }
    
    public Flight getFlight(){
        return flight;
    }

    @Override
    public String toString(){
        return ticketNumber;
    }
    public String getAirlinerName(){
        return flight.getAirliner().getName();
    }
    
    public Airliner getAirliner(){
        return flight.getAirliner();
    }
    
}
