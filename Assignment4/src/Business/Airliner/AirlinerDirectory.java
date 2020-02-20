
package Business.Airliner;

import java.util.ArrayList;


public class AirlinerDirectory {
    
    private ArrayList<Airliner> airlinerList;
    
    public AirlinerDirectory(){
        airlinerList = new ArrayList<>();
    }
    
    public ArrayList<Airliner> getAirlinerList(){
        return airlinerList;
    }
    
    public Airliner createAirliner(String name){

        Airliner airliner = new Airliner();
        airliner.setName(name);

        airlinerList.add(airliner);
        return airliner;
    }
    
    public void addAirliner(Airliner airliner){
        airlinerList.add(airliner);
    }
    
    public boolean removeAirliner(Airliner airliner){
        boolean success = airlinerList.remove(airliner);
        return success;
    }
}
