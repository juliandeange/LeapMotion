import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.Type;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.*;


/**
 * Created by juliandeangelis on 2016-04-24.
 */
public class CustomListener extends Listener {

    public Robot robot;

    public void onConnect (Controller c) {
        c.enableGesture(Gesture.Type.TYPE_CIRCLE);
        c.enableGesture(Gesture.Type.TYPE_SWIPE);
        c.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
    }

    public void onFrame (Controller c) {

        try {
            robot = new Robot();
        } catch (Exception e) {

        }

        Frame frame = c.frame();
        InteractionBox box = frame.interactionBox();
        for (Finger f : frame.fingers()) {
            if (f.type() == Finger.Type.TYPE_INDEX) {
                Vector fingerPos = f.stabilizedTipPosition();
                Vector boxFingerPos = box.normalizePoint(fingerPos);

                Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                robot.mouseMove((int)(screen.width * boxFingerPos.getX()), (int)(screen.height - boxFingerPos.getY() * screen.height));
            }
        }

        for (Gesture g : frame.gestures()) {
            if (g.type() == Type.TYPE_CIRCLE) {
                CircleGesture circle = new CircleGesture();
                if (circle.pointable().direction().angleTo(circle.normal()) <=  Math.PI / 4){
                    robot.mouseWheel(1);
                    try { Thread.sleep(50); } catch (Exception e) { }
                    }
                else {
                    robot.mouseWheel(-1);
                    try { Thread.sleep(50); } catch (Exception e) { }
                }
            }
            else if (g.type() == Type.TYPE_SCREEN_TAP) {
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
            }
        }
    }

}
