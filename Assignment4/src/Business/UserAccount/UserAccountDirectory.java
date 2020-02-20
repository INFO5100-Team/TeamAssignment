
package Business.UserAccount;

import Business.Airliner.Airliner;
import Business.TravelOffice.TravelOffice;
import java.util.ArrayList;

/**
 *
 * @author keshav
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password, String role){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password) &&ua.getRole().equals(role)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, String role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }

    
    public boolean deleteAirlinerUserAccount(Airliner airliner){
        boolean success = false;
        
        //jump out of the loop
        OUT:
        for(UserAccount ua : userAccountList){
            if(ua.getMember() instanceof Airliner){
                Airliner temp = (Airliner)ua.getMember();
                if(temp.equals(airliner)){
                    userAccountList.remove(ua);
                    success = true;
                    break OUT;
                }
            }
        } 
        return success;
    }
    
    public boolean deleteTravelOfficeUserAccount(TravelOffice to){
        boolean success = false;
        
        //jump out of the loop
        OUT:
        for(UserAccount ua : userAccountList){
            if(ua.getMember() instanceof TravelOffice){
                TravelOffice temp = (TravelOffice)ua.getMember();
                if(temp.equals(to)){
                    userAccountList.remove(ua);
                    success = true;
                    break OUT;
                }
            }
        } 
        return success;
    }

}
