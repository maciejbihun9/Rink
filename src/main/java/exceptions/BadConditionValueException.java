package exceptions;

import model.Skater;
import model.SkaterStatics;

/**
 * Created by Maciek on 2017-01-08.
 */
public class BadConditionValueException extends Exception  {

    public BadConditionValueException(){
        super("Condition must be set between : " + SkaterStatics.MIN_CONDITION + " and " + SkaterStatics.MAX_CONDITION);
    }
}
