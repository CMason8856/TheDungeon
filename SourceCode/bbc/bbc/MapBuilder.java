/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbc;

import java.awt.Graphics;

/**
 *
 * @author Bryce
 */
public class MapBuilder {
    public MapBuilder()
    {}
    
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
    protected static void Wall(Graphics g, int y, int size, int length, int door, int doorsize, int start)
    {   
        y*=10; size*=10; door*=10; doorsize*=10; start*=10;
        for( int t = start; t<=(door); t+=size )
        { Box wall = new Box(g, t, y); }
        for( int t = door+size+doorsize; t<(length*size); t+=size )
        { Box wall = new Box(g, t, y); }
    }
    
}
