import com.leapmotion.leap.*;

/**
 * Created by juliandeangelis on 2016-04-24.
 */

public class LeapMouse {
    public static void main (String [] args) {

        CustomListener listener = new CustomListener();
        Controller c = new Controller();
        c.addListener(listener);

        try {
            System.in.read();
        } catch (Exception e) {

        }

        c.removeListener(listener);

    }
}
