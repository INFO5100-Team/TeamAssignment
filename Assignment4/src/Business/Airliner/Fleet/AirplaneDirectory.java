
package Business.Airliner.Fleet;

import Business.Airliner.Airliner;
import Business.Airliner.Fleet.Airplane;
import java.util.ArrayList;

public class AirplaneDirectory {
    private ArrayList<Airplane> airplaneList;
    private Airplane airplane;
    
    public AirplaneDirectory(){
        this.airplaneList = new ArrayList<Airplane>();

    }

    public AirplaneDirectory(Airliner airliner) {
        airplaneList = new ArrayList<>();
    }

    public ArrayList<Airplane> getAirplaneList(){
        return airplaneList;
    }
    
    public Airplane createAirplane(){
        Airplane airplane = new Airplane();
        return airplane;
    }
    
    public Airplane searchAirplane(String name){
        Airplane air = new Airplane();
        for(Airplane airplane:airplaneList){
            System.err.println(airplane.getName());
            if(name.equals(airplane.getName())){
                air = airplane;
                break;
            }
            
        }
        return air;
    }
}
