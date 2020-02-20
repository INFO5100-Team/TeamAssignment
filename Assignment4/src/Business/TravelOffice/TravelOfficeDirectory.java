
package Business.TravelOffice;

import Business.TravelAgency.TravelAgency;
import java.awt.List;
import java.util.ArrayList;

public class TravelOfficeDirectory {
    
    private ArrayList<TravelOffice> travelOfficeList;
    private TravelAgency travelAgency;
    
    public TravelOfficeDirectory(TravelAgency travelAgency){
        travelOfficeList = new ArrayList<>();
        this.travelAgency = travelAgency;
    }
    
    public ArrayList<TravelOffice> getTravelOfficList(){
        return travelOfficeList;
    }
    
    public TravelOffice createTravelOffice(){
        TravelOffice travelOffice = new TravelOffice(this.travelAgency);
        travelOfficeList.add(travelOffice);
        return travelOffice;
    }
    
    public boolean removeTravelOffice(TravelOffice to){
        return travelOfficeList.remove(to);
    }
    
}
