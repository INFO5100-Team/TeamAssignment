
package Business.TravelAgency;

import java.util.ArrayList;

/**
 *
 * @author keshav
 */
public class TravelAgencyDirectory {
    
    private ArrayList<TravelAgency> travelAgencyList;
    
    public TravelAgencyDirectory(){
        travelAgencyList = new ArrayList<>();
    }
    
    public ArrayList<TravelAgency> getTavelAgencyList(){
        return travelAgencyList;
    }

}
