/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author Bryce
 */
public class Panel extends JPanel {

    static int x = 0;
    static int y = 0;
    static int mi = 10; //Movement increment
    static int MAX_HEIGHT = 600; //Change these to change window size
    static int MIN_HEIGHT = 0;
    static int MAX_WIDTH = 600; //Change these to change window size
    static int MIN_WIDTH = 0;
    public static Panel p = new Panel();

    public Panel() {
        setPreferredSize(new Dimension(MAX_HEIGHT, MAX_WIDTH));

    }

    @Override
    /**
     * calls paint method to update players model
     */
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    /**
     * Paints the designated player object to a certain spot
     */
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(x, y, 10, 10);
        ObjectController.InitializeBoxes(g);

    }

    /**
     * Controls for moving player with corresponding values and limitations
     *
     * @param ke - current key event
     */
    static void keyPressed(KeyEvent ke) {
        int i = ke.getKeyCode();
        switch (i) {
            case KeyEvent.VK_W:
                if (!collisionDetection(-mi)) {
                    manipulateY(-mi);
                }
                ;
                break;
            case KeyEvent.VK_A:
                if (!collisionDetection(-mi)) {
                    manipulateX(-mi);
                }
                ;
                break;
            case KeyEvent.VK_S:
                if (!collisionDetection(mi)) {
                    manipulateY(mi);
                }
                ;
                break;
            case KeyEvent.VK_D:
                if (!collisionDetection(mi)) {
                    manipulateX(mi);
                }
                ;
                break;

        }
    }

    /**
     * Allows for manipulation of Y value
     *
     * @param m - the amount to change 'Y' by
     */
    public static void manipulateY(int m) {
        y += m;
    }

    /**
     * Allows for manipulation of X value
     *
     * @param m - the amount to change 'X' by
     */
    public static void manipulateX(int m) {
        x += m;
    }

    /**
     * Checks for collisions
     *
     * @param am - amount to modify X/Y
     * @return conflict - boolean value of if the move works
     */
    private static boolean collisionDetection(int am) //Use this variable to control sticking
    {
        boolean conflictX = false;
        boolean conflictY = false;
        for (Box i : Box.Box) {
            for (int f = 0; f <= am; f++) {
                if (x + f > x) //if positive X
                {
                    for (int ff = 0; ff <= am; ff++) {
                        if (x + f == i.getCordX() + ff) {
                            conflictX = true;
                        }
                    }
                } else //if negative X
                {
                    for (int fF = 0; fF >= am; fF++) {
                        if (x - f == i.getCordX() - fF) {
                            conflictX = true;
                        }
                    }
                }

                if (y + f > y) //if positive Y
                {
                    for (int Ff = 0; Ff <= am; Ff++) {
                        if (y + f == i.getCordY() + Ff) {
                            conflictY = true;
                        }

                    }
                } else //if negative Y
                {
                    for (int FF = 0; FF >= am; FF++) {
                        if (y - f == i.getCordY() - FF) {
                            conflictY = true;
                        }
                    }
                }
            }
        }
        if (conflictX == conflictY && conflictX == true) {
            return true;
        } else {
            return false;
        }

    }

    public static JPanel getCurrentPanel() {
        return p;
    }
}
