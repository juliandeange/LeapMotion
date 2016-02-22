import com.leapmotion.leap.*;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juliandeangelis
 */
       class SampleListener extends Listener {
    
    public void onConnect (Controller controller) {
        System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
    }

    public void onFrame (Controller controller) {
        Frame frame = controller.frame();
        /*System.out.println("Frame id: " + frame.id()
                   + ", timestamp: " + frame.timestamp()
                   + ", hands: " + frame.hands().count()
                   + ", fingers: " + frame.fingers().count()
                   + ", tools: " + frame.tools().count()
                   + ", gestures " + frame.gestures().count());
        */

        for (Hand hand: frame.hands()) {
            String handType = hand.isLeft() ? "Left Hand" : "Right Hand";
            System.out.println(handType + " " + ", id: " + hand.id() + " , Palm Position: " + hand.palmPosition());

            Vector normal = hand.palmNormal();
            Vector direction = hand.direction();
            System.out.println("Pitch: " + Math.toDegrees(direction.pitch()) +
                    "Roll: " + Math.toDegrees(normal.roll()) +
                    "Yaw : " + Math.toDegrees(direction.yaw()));
        }
    }   
}


