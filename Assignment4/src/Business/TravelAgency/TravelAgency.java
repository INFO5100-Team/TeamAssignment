package Business.TravelAgency;

import Business.Airliner.Airliner;
import Business.Airliner.AirlinerDirectory;
import Business.MasterTravelSchedule;
import Business.TravelOffice.TravelOffice;
import Business.TravelOffice.TravelOfficeDirectory;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;

/**
 * 1. manage airliner:add, remove airliner, cannot modify the flight schedule(this should be done by airliner itself).
 * 2. manage travel office, add, remove travel office,similar as airliner 
 * 3. deal with pending tickets, booking those tickets for customer
 * @author sathwik
 *     
 */
public class TravelAgency {
    
    private UserAccountDirectory userAccountDirectory;
    // multi-Airliner
    private AirlinerDirectory airlinerDirectory;
    // multi-Retailer
    private TravelOfficeDirectory travelOfficeDirectory;
    
    private MasterTravelSchedule masterTS;
    
    public TravelAgency(){
        this.userAccountDirectory = new UserAccountDirectory();
        this.airlinerDirectory = new AirlinerDirectory();
        this.travelOfficeDirectory = new TravelOfficeDirectory(this);
        masterTS = MasterTravelSchedule.getInstance();
    }

    public AirlinerDirectory getAirlinerDirectory() {
        return airlinerDirectory;
    }

    public TravelOfficeDirectory getTravelOfficeDirectory() {
        return travelOfficeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }
    
    
    /**
     * Help airliner register(add new user account to user directory) and build a new airliner(name).
     * *Each time add a airliner, add it to the MasterTravelSchedule
     * *Airliner Id is generated automatically
     * @param airliner
     * @param username
     * @param password 
     */
    public Airliner addAirliner(String name,String userAccountName, String userAccountPassword){
        Airliner airliner = airlinerDirectory.createAirliner(name);
        
        UserAccount ua = userAccountDirectory.createUserAccount(userAccountName, userAccountPassword, "Airliner");
        ua.setMember(airliner);
        
        masterTS.addAirliner(airliner);
        
        return airliner;
    }
//    
//    public void addAirlinerForConfig(Airliner airliner,String userAccountName, String userAccountPassword){
//        airlinerDirectory.addAirliner(airliner);
//        
//        UserAccount ua = userAccountDirectory.createUserAccount(userAccountName, userAccountPassword, "Airliner");
//        ua.setMember(airliner);
//        
//        masterTS.addAirliner(airliner);
//    }
    
    /**
     * Delete the airliner.
     * delete it from travelAgency's airlinerDir & user account directory;
     * and remove it from the masterTS's airlinerDir
     * @param airliner
     * @return deleted airliner
     */
    public Airliner removeAirliner(Airliner airliner){
        Airliner deletedAirliner = null;
        if(airlinerDirectory.removeAirliner(airliner)
                &&masterTS.removeAirliner(airliner)
                &&userAccountDirectory.deleteAirlinerUserAccount(airliner)){
            deletedAirliner = airliner;
        }else{
            System.err.println("removeAirliner: can't remove, it seems can't find this airliner in airlinerDir/masterTS/userAccountDir");
        }
        
        return deletedAirliner;
    }
    
    /**
     * Generate a new object of TravelOffice with given name, user account name and password.
     * you could still add customers to the travel office by the method returning the new object
     * @param name
     * @param userAccountName
     * @param userAccountPassword
     * @return the generated object of TravelOffice class
     */
    public TravelOffice addTravelOffice(String name, String userAccountName, String userAccountPassword){
        TravelOffice to = travelOfficeDirectory.createTravelOffice();
        to.setName(name);
        
        UserAccount ua = userAccountDirectory.createUserAccount(userAccountName, userAccountPassword, "TravelOffice");
        ua.setMember(to);
        
        return to;
    }
    
    /**
     * Delete the travel office.
     * delete it from travelAgency's travelOfficeDir & user account directory;
     * @param travel office
     * @return deleted travel office
     */
    public TravelOffice removeTravelOffice(TravelOffice to){
        TravelOffice deletedTO = null;
         if(travelOfficeDirectory.removeTravelOffice(to)
                &&userAccountDirectory.deleteTravelOfficeUserAccount(to)){
            deletedTO = to;
        }else{
            System.err.println("removeTravelOffice: can't remove, it seems can't find this travel office in travelOfficeDir/userAccountDir");
        }
        
        return deletedTO;
    }
    
    /**
     * 
     */
    public boolean isAirlinerNameDuplicated(String name){
        boolean isDuplicate = false;
        for(Airliner airliner : airlinerDirectory.getAirlinerList()){
            if(airliner.getName().equals(name)){
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }
    
    public boolean isUserNameDuplicated(String username){
        boolean isDuplicate = false;
        for(UserAccount userAccount : userAccountDirectory.getUserAccountList()){
            if(userAccount.getUsername().equals(username)){
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }
    
    public boolean isTravelOfficeNameDuplicated(String name){
        boolean isDuplicate = false;
        for(TravelOffice to : travelOfficeDirectory.getTravelOfficList()){
            if(to.getName().equals(name)){
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }

}
