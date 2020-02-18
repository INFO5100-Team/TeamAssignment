
package Business;

import Business.TravelAgency.TravelAgencyDirectory;

public class Business {
    
    private static Business superAdmin;
    private TravelAgencyDirectory travelAgencyDirectory;
    
    public static Business getInstance(){
        if(superAdmin == null){
            superAdmin = new Business();
        }
        
        return superAdmin;
    }
    
    private Business(){
        travelAgencyDirectory = new TravelAgencyDirectory();
    }
    
    public TravelAgencyDirectory getTravelAgencyDirectory (){
        return travelAgencyDirectory;
    }
}
