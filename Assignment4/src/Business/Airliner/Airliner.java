
package Business.Airliner;



import Business.Airliner.Fleet.AirplaneDirectory;
import Business.Airliner.Flight.FlightSchedual;
import Business.Ticket.Ticket;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;


public class Airliner {
    // CRUD for Flight
    // one Airliner has one fleet
      
    private UserAccount userAccount;
    private String id;
    private String name;
    private AirplaneDirectory airplaneDirectory;
    private FlightSchedual flightSchedual;
    private static int count = 1;
    private List<Ticket> orderedTickets;
    
    public Airliner(String name){
        this.flightSchedual = new FlightSchedual(this);
        this.airplaneDirectory =new AirplaneDirectory();
        this.name = name;
        this.id = String.format("%05d", count);
        count ++;
        orderedTickets = new ArrayList<>();
    }
    
    public Airliner(){
        this.flightSchedual = new FlightSchedual(this);
        this.airplaneDirectory =new AirplaneDirectory();
//        this.name = name;
        this.id = String.format("%05d", count);
        count ++;
        orderedTickets = new ArrayList<>();
    }
    
    public void addOrderedTicket(Ticket t){
        orderedTickets.add(t);
    }
    
    public List<Ticket> getOrderedTicketList(){
        return orderedTickets;
    }
    

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirplaneDirectory getAirplaneDirectory() {
        return airplaneDirectory;
    }

    public void setAirplaneDirectory(AirplaneDirectory airplaneDirectory) {
        this.airplaneDirectory = airplaneDirectory;
    }

    public FlightSchedual getFlightSchedual() {
        return flightSchedual;
    }

    public void setFlightSchedual(FlightSchedual flightSchedual) {
        this.flightSchedual = flightSchedual;
    }
    
    @Override
    public String toString(){
        return this.id;
    }

    public int getFlightsNum(){
        return this.flightSchedual.getFlghtList().size();
    }
    
    public int getAirplaneNum(){
        return this.airplaneDirectory.getAirplaneList().size();
    }

    



   
}
