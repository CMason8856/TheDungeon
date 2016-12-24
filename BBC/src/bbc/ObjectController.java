/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbc;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Bryce
 */
public class ObjectController {
    static ObjectController oc;
    
    public ObjectController(Graphics g, int x, int y)
    {
        
    }
    
    public static ObjectController getInstance()
    { return oc; }
    
    public static void InitializeBoxes(Graphics g)
    {
        Box a = new Box(g,60,50);
        Box b = new Box(g,70,50);
        Box c = new Box(g,80,50);
        Box d = new Box(g,90,50);
    }
}
