package personel;

import model.Skater;
import model.SkatersQueue;

/**
 * Created by Maciek on 2016-12-22.
 * There is only one receptionist, so we
 * can not be able to allow program user to
 * create a new Receptionist instance.
 */
public class Receptionist {

    private static Receptionist receptionist = new Receptionist();

    private Receptionist(){

    }

    public static Receptionist getReceptionist(){
        return receptionist;
    }

    public void addClientToSkaterQueue(Skater newClient){
        SkatersQueue.addClient(newClient);
    }

}
