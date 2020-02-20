
package Business.Airliner.Fleet;

import Business.Airliner.Airliner;
import Business.UserAccount.UserAccount;


public class Airplane {
    // how many seats for a single Ariplane
    private String name;  
    private int seatNumber;
    private Airliner airliner;
    private String serialNum;
    
    public Airplane(){
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Airliner getAirliner() {
        return airliner;
    }

    public void setAirliner(Airliner airliner) {
        this.airliner = airliner;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    @Override
    public String toString(){
        return name;
    }


}

