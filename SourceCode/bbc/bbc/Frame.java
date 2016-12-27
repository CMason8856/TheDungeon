/*
 * The Frame is the backend and support of the JPanel Panel, it is the actual window while the Panel is everything inside
 */
package bbc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Bryce
 */
public class Frame extends JFrame implements KeyListener {

    private static JPanel frame;
    JPanel p = Controls.getCurrentPanel();

    public Frame() {
        super();
        frame = new Panel();
        add(frame);
        pack();
        addKeyListener(this);
        repaint();
    }

    public static void main(String[] args) {
        Frame window = new Frame();
        window.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setTitle("BBC");

    }

    /**
     *      Repaint an object (the player)
     */
    @Override
    public void repaint() {
        super.repaint();
    }

    /**
     *      Key pressed events
     *
     * @param ke - the current key event
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        int k = ke.getKeyCode();
        Controls.keyPressed(k);
        repaint();
    }
    
    /**
     *      AI Key pressing events
     *  -Alice, please press....
     */
    public static void AIkeyPressed() {
        Robot Alice;
        try {
            Alice = new Robot();
            Alice.keyPress(KeyEvent.VK_K);
        } 
        catch (AWTException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *      Key typed event
     * @param ke - the current key event
     */
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    
    /**
     *      Key Released event
     * @param ke - the current key event
     */
    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    /**
     *      Returns the current frame
     * @return frame - the current frame
     */
    public static JPanel getFrame()
    { return frame; }

}
