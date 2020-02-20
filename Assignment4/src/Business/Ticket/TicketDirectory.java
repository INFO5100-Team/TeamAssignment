
package Business.Ticket;

import Business.TravelOffice.TravelOffice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author keshav
 */
public class TicketDirectory {
    
    private List<Ticket> ticketList;
    
    public TicketDirectory(TravelOffice travelOffice){
        this.ticketList = new ArrayList<>();
    }
    
    public List<Ticket> getTicketList(){
        return this.ticketList;
    }

}
