package personel;

/**
 * Created by Maciek on 2016-12-22.
 * There is only one coordinator in the area.
 * He gets Customers and placing them in the ice panel area.
 */
public class Coordinator {

    private static Coordinator iceCoordinator = new Coordinator();

    private Coordinator(){

    }

    public static Coordinator getIceCoordinator(){
        return iceCoordinator;
    }

    public void letSkaterOnTheIce(){

    }

    public void leadOutSkater(){

    }

}
