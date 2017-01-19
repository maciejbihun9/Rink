package concurrentComponenets;
import icepanelbusiness.IceRinkRepo;
import icepanelbusiness.IceRinkValidator;
import model.Skater;
import model.SkaterStatics;
import java.util.TimerTask;

/**
 * Created by Maciek on 2017-01-14.
 */
public class SkaterMover extends TimerTask {

    public void run() {
        IceRinkRepo.moveSkaters();
    }
}
