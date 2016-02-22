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
public class Main {
    
    public static void main (String [] args) {
    
    SampleListener listener = new SampleListener();
    Controller controller = new Controller();
        
    controller.addListener(listener);
    
    System.out.println("Press Enter to quit"); 
    try {
        System.in.read();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    controller.removeListener(listener);
    
    }
}
