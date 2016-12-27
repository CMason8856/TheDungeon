/*
 *  Box is the main Object / building material []
 */
package bbc;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Bryce, Billy
 */
public class Box extends ObjectController {

    private final int BOX_HEIGHT = 10; //Box height color and width values
    private final int BOX_WIDTH = 10;
    private final int x;
    private final int y;
    ObjectController oc = ObjectController.getInstance();
    public static ArrayList<Box> Box = new ArrayList<>();

    public Box(Graphics g, int x, int y) {
        super(g, x, y);
        this.x = x;
        this.y = y;
        Box.add(this);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, BOX_HEIGHT, BOX_WIDTH);
    }

    /**
     *      Returns the x cord from this object
     *
     * @return x - the x cord
     */
    public int getCordX() {
        return this.x;
    }

    /**
     *      Returns the y cord from this object
     *
     * @return y - the y cord
     */
    public int getCordY() {
        return this.y;
    }

    /**
     *      Returns HEIGHT of this object
     *
     * @return x - the x cord
     */
    public int getHeight() {
        return this.BOX_HEIGHT;
    }

    /**
     *      Returns the WIDTH of this object
     *
     * @return y - the y cord
     */
    public int getWidth() {
        return this.BOX_WIDTH;
    }
    
    /**
     *      Deals with redrawing all them there box objects
     * @param g - Graphics
     * @param x - x value of object
     * @param y - y value of object
     */
    public void redraw(Graphics g, int x, int y) { //to deal with the fuckton of box objects #funkyTown
        Goal.redraw(g);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, BOX_HEIGHT, BOX_WIDTH);
    }
}
