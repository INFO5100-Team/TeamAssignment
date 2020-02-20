
package Business.UserAccount;

import Business.Airliner.Airliner;
import Business.TravelOffice.TravelOffice;

/**
 *
 * @author keshav
 */
public class UserAccount {
     
    private String username;
    private String password;
    private String role;
    
    private Airliner airliner;
    private TravelOffice travelOffice;

    public UserAccount(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        
    }
    
    public UserAccount(){
        
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setMember(Airliner airliner){
        this.airliner = airliner;
        this.travelOffice = null;
    }
    
    public void setMember(TravelOffice travelOffice){
        this.travelOffice = travelOffice;
        this.airliner = null;
    }
    
    public Object getMember(){
        if(this.travelOffice != null){
            return this.travelOffice;
        }else if(this.airliner != null){
            return this.airliner;
        }
        return null;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    @Override
    public String toString() {
        return username;
    }
    
    
}
