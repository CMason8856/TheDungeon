/*
 * Abstract class of all Game objects 
 */
package bbc;

import java.awt.Graphics;

/**
 *
 * @author Bryce, Billeh
 */
public class ObjectController {

    static ObjectController oc;

    public ObjectController(Graphics g, int x, int y) {}

    /**
     *      Returns the current ObjectController
     * @return 
     */
    public static ObjectController getInstance() {
        return oc;
    }
}
