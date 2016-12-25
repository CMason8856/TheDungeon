/*
 * Responsible for loading maps and game objects into real maps and game objects :P
 */
package bbc;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author Bryce
 */
public class Maps {
    protected static ArrayList<String> mapList = new ArrayList<>();
    private static boolean initialized;
    private static String currentMap;
    public Maps(){
    }
    /**
     *   Add any map additions into the switch statement to be selected
     * @param g 
     */
    public static void selectMap(Graphics g)
    {
        System.out.println("What map would you like to load?");
        
        Iterator itr = mapList.iterator();
        while(itr.hasNext()) { System.out.println("Map: "+itr.next().toString()); }
       
        Scanner input = new Scanner(System.in);
        String mapName = input.next();
        switch(mapName){
            case "TestMap": TestMap(g,'y'); currentMap = mapName; break;
            case "Diamonds": Diamonds(g,'y'); currentMap = mapName; break;
            default: System.out.println("Error in selectMap"); break;
        }
    }
    
    /**
     *   Loads maps to then be selected and used by the game
     * @param g - Graphics
     */
    public static void initializeMaps(Graphics g)
    {
        TestMap(g,'i');
        Diamonds(g,'i');
        initialized = true;
    }
    
    /**
     *  Loads the selected map into the game
     * @param g - Graphics object
     * @param map - map name
     */
    public static void loadMap(Graphics g, String map){
        switch(map){
            case "TestMap": TestMap(g,'y'); break;
            case "Diamonds": Diamonds(g,'y'); break;
            default: System.out.println("Error in load map"); break;
        }
    }
    
    /**
     *   Returns the current map
     * @return string currentMap
     */
    public static String getCurrentMap()
    {return currentMap;}
    
    /**
     *   Returns whether it is initialized or not
     * @return - bool initialized
     */
    public static boolean initialized()
    {return initialized;}
    
    //MAPS------------------------------***
    
    /**     (Put short map description here of your map)    **
     *   Put any and all game world objects right in HEUYAW
     * @param g - Graphics object (important)
     */
    public static void TestMap(Graphics g, char start) { //the ultimate ghetto singleton method (240 was actually useful :D) 
        String TestMap = null; //Make sure to change the name of this with new maps
        if(start=='i') { mapList.add("TestMap"); }
        if (TestMap == null && start=='y') {
           
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,i,1,10,8-i,2,0); } // To reverse direction of tunneling, take (door - doorsize)-i for the door.
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,i,1,20,10+i,2,10); } 
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,5+i,1,10,1+i,2,0); } 
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,5+i,1,20,16-i,2,10); } 
            new Goal(g,10,180);
            TestMap = "Initialized";
        }
        else {
            for (Box box : Box.Box) { box.redraw(g, box.getCordX(), box.getCordY());}
        }
    }
    
    /**     Diamonds    **
     *   
     * @param g - Graphics object (important)
     */
    public static void Diamonds(Graphics g, char start) { //the ultimate ghetto singleton method (240 was actually useful :D) 
        String Diamonds = null; 
        if(start=='i') { mapList.add("Diamonds"); }
        if (Diamonds == null && start=='y') {
           
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,i,1,10,8-i,2,0); } 
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,i,1,20,10+i,2,10); } 
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,5+i,1,10,1+i,2,0); } 
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,5+i,1,20,16-i,2,10); }
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,10+i,1,10,8-i,2,0); } 
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,10+i,1,20,10+i,2,10); } 
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,15+i,1,10,1+i,2,0); } 
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,15+i,1,20,16-i,2,10); } 
            new Goal(g,10,180);
            Diamonds = "Initialized";
        }
        else {
            for (Box box : Box.Box) { box.redraw(g, box.getCordX(), box.getCordY());}
        }
    }
    
}
