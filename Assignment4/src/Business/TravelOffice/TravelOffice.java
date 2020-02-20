
package Business.TravelOffice;

import Business.Airliner.Airliner;
import Business.Airliner.Flight.Flight;
import Business.Airliner.Flight.FlightSchedual;
import Business.Ticket.Ticket;
import Business.Ticket.TicketDirectory;
import Business.TravelAgency.TravelAgency;
import Business.TravelOffice.Customer.*;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TravelOffice {
    // Attributes of TravelOffice
    private String name;
    private String id;
    private static int count = 1;
    private boolean hasPendingTicket;
    // Includes customerDirectory
    private CustomerDirectory customerDirectory;
    private FlightSchedual flightSchedule;
    private TicketDirectory ticketDirectory;
   
    
    private UserAccount userAccount;
    
    private TravelAgency travelAgency;
    
    // Have the function of generate pending ticket
    
    
    public TravelOffice(TravelAgency travelAgency){
        id = Integer.toString(count);
        count ++;       
        this.customerDirectory = new CustomerDirectory(this);
        this.travelAgency = travelAgency;
        this.ticketDirectory = new TicketDirectory(this);
    }
    
    public void setUserAccount(){
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public TicketDirectory getTicketDirectory() {
        return ticketDirectory;
    }
    
    public List<Flight> getFlightList(){
        List<Airliner> airlinerList = this.travelAgency.getAirlinerDirectory().getAirlinerList();
        List<Flight> allFlightList = new ArrayList<>();
        for(Airliner airliner : airlinerList){
            allFlightList.addAll(airliner.getFlightSchedual().getFlghtList());
        }
        return allFlightList;
    }
    
    public List<Ticket> getPendingTicket(){
        return this.ticketDirectory.getTicketList().stream()
                .filter(ticket -> ticket.isPending() == true)
                .collect(Collectors.toList());
    }
 
    @Override
    public String toString(){
        return id;
    }
    
}
