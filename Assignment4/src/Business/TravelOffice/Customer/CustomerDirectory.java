
package Business.TravelOffice.Customer;

import Business.TravelOffice.TravelOffice;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author keshav
 */
public class CustomerDirectory {
    Customer customer;
    List<Customer> customerList;
    String officeInfo;
    
    public CustomerDirectory(TravelOffice travelOffice){
        this.officeInfo = travelOffice.getName();
        customerList = new ArrayList<>();
    }
    
    public List<Customer> getCustomerList(){
        return customerList;
    }
    
    public int getCustomerNum(){
        return customerList.size();
    }
}
