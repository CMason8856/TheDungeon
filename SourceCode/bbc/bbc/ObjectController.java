/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbc;

import java.awt.Graphics;

/**
 *
 * @author Bryce, Billeh
 */
public class ObjectController {

    private static String initializedBoxes;
    static ObjectController oc;

    public ObjectController(Graphics g, int x, int y) {}

    public static ObjectController getInstance() {
        return oc;
    }

    /**
     *   Put any and all game world objects right HEUYAW
     * @param g - Graphics object (important)
     */
    public static void InitializeBoxes(Graphics g) { //the ultimate ghetto singleton method (240 was actually useful :D) 
        if (initializedBoxes == null) {
           
            for(int i = 1; i<=5; i++) {Wall(g,i,1,10,8-i,2,0); } // To reverse direction of tunneling, take (door - doorsize)-i for the door.
            for(int i = 1; i<=5; i++) {Wall(g,i,1,20,10+i,2,10); } 
            for(int i = 1; i<=5; i++) {Wall(g,5+i,1,10,1+i,2,0); } 
            for(int i = 1; i<=5; i++) {Wall(g,5+i,1,20,16-i,2,10); } 
            Goal win = new Goal(g,10,180);
           
            initializedBoxes = "Initialized";
        }
        else {
            for (Box box : Box.Box) {
                box.redraw(g, box.getCordX(), box.getCordY());
            }
        }
    }
    
    //Support for shapes and stuff
    
    /**   PLS USE X VALUES THAT GO IN GROUPS OF 10 FOR BEST RESULTS *** <-------------------------- READ ALL PLS
     *      -Also read param tags to understand, its a lot but its super versatile
     *          -If you put zero for door size or door you get no door
     *              - VARIABLES ARE ALMOST ALL (EXCEPT LENGTH) MULTIPLED BY 10 FOR CONVIENCE, KEEP THIS IN MIND
     *                  -Also exits take up space going right from your ending block :P
     * 
     *  Builds Trumps Walls all around the country
     * @param g - Graphics, its graphics
     * @param y - the Y value to start the wall at
     * @param size - size of the block
     * @param length - Length of the wall (how much brick you lay'in to keep those damn illegals out)
     * @param door - where the entrance hole is
     * @param doorsize - size of the entry hole
     * @param start - starting point of Wall on x axis
     */
    public static void Wall(Graphics g, int y, int size, int length, int door, int doorsize, int start)
    {   
        y*=10; size*=10; door*=10; doorsize*=10; start*=10;
        for( int t = start; t<=(door); t+=size )
        { Box wall = new Box(g, t, y); }
        for( int t = door+size+doorsize; t<(length*size); t+=size )
        { Box wall = new Box(g, t, y); }
    }
}
