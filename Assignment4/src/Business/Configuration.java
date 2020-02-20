
package Business;

import Business.Airliner.Airliner;
import Business.Airliner.Fleet.Airplane;
import Business.Airliner.Flight.Flight;
import Business.TravelAgency.TravelAgency;
import Business.TravelOffice.Customer.Customer;
import Business.TravelOffice.TravelOffice;
import Business.UserAccount.UserAccount;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author keshav
 */
public class Configuration {
    
    public static Business configure(){
        
        Business business = Business.getInstance();
        
        TravelAgency travelAgency = new TravelAgency();        
        business.getTravelAgencyDirectory().getTavelAgencyList().add(travelAgency);
                
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("Keshav");
        userAccount.setPassword("Keshav");
        userAccount.setRole("TravelAgency");
        
        travelAgency.getUserAccountDirectory().getUserAccountList().add(userAccount);
        
//        AirlinerDirectory airlinerDirectory = new AirlinerDirectory();
        configureAirliner(travelAgency);
        configureTravelOffice(travelAgency);
        
        return business;
    }
    
    private static void configureAirliner(TravelAgency travelAgency){

        
        Airliner airliner1 = travelAgency.addAirliner("BlueJet", "BlueJet", "111");
        Airliner airliner2 = travelAgency.addAirliner("United Airlines", "United Airlines", "222");

        ArrayList<Airliner> airlinerList= new ArrayList<>();
        airlinerList.add(airliner1);
        airlinerList.add(airliner2);
        
        configureAirplane(airlinerList);
        
    }
    public static void configureAirplane(ArrayList<Airliner> airlinerList){
        Airliner airliner1 = airlinerList.get(0);
        Airliner airliner2 = airlinerList.get(1);
        
        Airplane airplane1 = new Airplane();
        airplane1.setName("A350");
        airplane1.setSeatNumber(300);
        airplane1.setSerialNum("0001");
        airplane1.setAirliner(airliner1);
        airliner1.getAirplaneDirectory().getAirplaneList().add(airplane1);
        
        Airplane airplane2 = new Airplane();
        airplane2.setName("B737");
        airplane2.setSerialNum("0002");
        airplane2.setSeatNumber(300);
        airplane2.setAirliner(airliner1);
        airliner1.getAirplaneDirectory().getAirplaneList().add(airplane2);
        
        Airplane airplane3 = new Airplane();
        airplane3.setName("A350");
        airplane3.setSerialNum("0003");
        airplane3.setSeatNumber(350);
        airplane3.setAirliner(airliner2);
        airliner2.getAirplaneDirectory().getAirplaneList().add(airplane3);
        
        Airplane airplane4 = new Airplane();
        airplane4.setName("B787");
        airplane4.setSerialNum("0004");
        airplane4.setSeatNumber(350);
        airplane4.setAirliner(airliner2);
        airliner2.getAirplaneDirectory().getAirplaneList().add(airplane4);
        
        
        ArrayList<Airplane> airplaneList= new ArrayList<>();
        airplaneList.add(airplane1);
        airplaneList.add(airplane2);
        airplaneList.add(airplane3);
        airplaneList.add(airplane4);
        
        configureFlight(airplaneList);
        
        
    }
    public static void configureFlight(ArrayList<Airplane> airplaneList){
        try {

            Airplane airplane1 = airplaneList.get(0);
            Airplane airplane2 = airplaneList.get(1);
            Airplane airplane3 = airplaneList.get(2);
            Airplane airplane4 = airplaneList.get(3);

            Airliner airliner1 = airplane1.getAirliner();
            Airliner airliner2 = airplane3.getAirliner();


            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date d1 = format.parse("2020-02-01");
            Date d2 = format.parse("2020-01-01");
            Date d3 = format.parse("2020-01-03");
            Date d4 = format.parse("2020-02-15");
            
            SimpleDateFormat format2 = new SimpleDateFormat("hh:mm");
            LocalTime st1 = LocalTime.of(12, 10);
            LocalTime at1 = LocalTime.of(2,30);
            LocalTime st2 = LocalTime.of(10,12);
            LocalTime at2 = LocalTime.of(3,12);
            LocalTime st3 = LocalTime.of(12,23);
            LocalTime at3 = LocalTime.of(19,12);
            LocalTime st4 = LocalTime.of(6,0);
            LocalTime at4 = LocalTime.of(13,13);
            
            
            

            Flight f1 = new Flight(airliner1,"CJ5188",airplane1,"BOS","SHA",d1,st1,at1,500);
            Flight f2 = new Flight(airliner1,"KW9877",airplane2,"NYC","LON",d2,st2,at2,354);
            Flight f3 = new Flight(airliner2,"DM7768",airplane3,"BOS","SHA",d3,st3,at3,800);
            Flight f4 = new Flight(airliner2,"WS2122",airplane4,"NYC","LAX",d4,st4,at4,352);

            airliner1.getFlightSchedual().getFlghtList().add(f1);
            airliner1.getFlightSchedual().getFlghtList().add(f2);
            airliner2.getFlightSchedual().getFlghtList().add(f3);
            airliner2.getFlightSchedual().getFlghtList().add(f4);
        } catch (ParseException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void configureTravelOffice(TravelAgency travelAgency) {
        TravelOffice travelOffice = new TravelOffice(travelAgency);
        travelOffice.setName("BOS_LOGAN");
        travelAgency.getTravelOfficeDirectory().getTravelOfficList().add(travelOffice);
        
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("Boston");
        userAccount.setPassword("Boston");
        userAccount.setRole("TravelOffice");
        userAccount.setMember(travelOffice);
        
        travelAgency.getUserAccountDirectory().getUserAccountList().add(userAccount);
        
        configureCustomer(travelOffice);
    
    }
    
    public static void configureCustomer(TravelOffice travelOffice){
        Customer customer1 = new Customer(travelOffice);
        customer1.setName("Keshav");
        customer1.setIdentityType("Passport");
        customer1.setIdentityID("P6602207");
        
        
        Customer customer2 = new Customer(travelOffice);
        customer2.setName("Jiyuan");
        customer2.setIdentityType("Passport");
        customer2.setIdentityID("E332211");
        
        travelOffice.getCustomerDirectory().getCustomerList().add(customer1);
        travelOffice.getCustomerDirectory().getCustomerList().add(customer2);

    }
   
  
}
