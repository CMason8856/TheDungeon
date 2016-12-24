/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbc;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Bryce
 */
public class Box extends ObjectController{
    
    
    private final int BOX_HEIGHT = 10; //Box height color and width values
    private final int BOX_WIDTH = 10;
    private final int x;
    private final int y;
    private final String BOX_COLOR = "BLACK";
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
     * Returns the x cord from this object
     * @return x - the x cord
     */
    public int getCordX()
    { return this.x; }
    /**
     * Returns the y cord from this object
     * @return y - the y cord
     */
    public int getCordY()
    { return this.y; }
    /**
     * Returns HEIGHT of this object
     * @return x - the x cord
     */
    public int getHeight()
    { return this.BOX_HEIGHT; }
    /**
     * Returns the WIDTH of this object
     * @return y - the y cord
     */
    public int getWidth()
    { return this.BOX_WIDTH; }
    
    
    
   
    
            
}
