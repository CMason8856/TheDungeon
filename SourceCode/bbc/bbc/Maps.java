/*
 *      Responsible for loading maps and game objects into real maps and game objects :P
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
     *      Add any map additions into the switch statement to be selected
     * @param g - Graphics
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
            case "AITestMap": AI_Test_Map(g,'y'); currentMap = mapName; break;
            default: System.out.println("Error in selectMap"); break;
        }
    }
    
    /**
     *      Loads maps to then be selected and used by the game
     * @param g - Graphics
     */
    public static void initializeMaps(Graphics g)
    {
        TestMap(g,'i');
        Diamonds(g,'i');
        AI_Test_Map(g,'i');
        initialized = true;
    }
    
    /**
     *      Loads the selected map into the game
     * @param g - Graphics object
     * @param map - map name
     */
    public static void loadMap(Graphics g, String map){
        switch(map){
            case "TestMap": TestMap(g,'y'); currentMap = map; break;
            case "Diamonds": Diamonds(g,'y'); currentMap = map; break;
            case "AITestMap": AI_Test_Map(g,'y'); currentMap = map; break;
            default: System.out.println("Error in load map"); currentMap = map; break;
        }
    }
    
    /**
     *      Returns the current map
     * @return string currentMap
     */
    public static String getCurrentMap()
    {return currentMap;}
    
    /**
     *      Returns whether it is initialized or not
     * @return - boolen initialized
     */
    public static boolean initialized()
    {return initialized;}
    
    
    //MAPS----------------------------------------------------------------------***
    
    /**     (Put short map description here of your map)    **
     *   
     * @param g - Graphics object (important)
     */
    public static void TestMap(Graphics g, char start) { //the ultimate ghetto singleton method (240 was actually useful :D) 
        String TestMap = null; //Make sure to change the name of this with new maps
        if(start=='i') { mapList.add("TestMap"); } // Also change what is added to the array list here to your map's call name
        if (TestMap == null && start=='y') {
           
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,i,1,10,8-i,2,0); } // Change these to whatever you want your map to have wall wise
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,i,1,20,10+i,2,10); } 
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,5+i,1,10,1+i,2,0); } 
            for(int i = 1; i<=5; i++) {MapBuilder.Wall(g,5+i,1,20,16-i,2,10); } 
            new Goal(g,10,180); //Change value of goal to a spot that works for your map
            TestMap = "Initialized"; //Also make sure to add your map to the switch statement for selections
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
    
    /**     AI_Test_Map    **
     *   
     * @param g - Graphics object (important)
     */
    public static void AI_Test_Map(Graphics g, char start) { //the ultimate ghetto singleton method (240 was actually useful :D) 
        String AI_Test_Map = null; 
        if(start=='i') { mapList.add("AITestMap"); }
        if (AI_Test_Map == null && start=='y') {
           
            MapBuilder.Wall(g, 0, 1, 10, 0, 0, 0);
            MapBuilder.Wall(g, 25, 1, 10, 0, 0, 0);
            MapBuilder.Column(g, 10, 0, 30);
            MapBuilder.Column(g, 0, 0, 30);
            for(int i = 3; i<=7; i++) {MapBuilder.Wall(g,i,1,10,i,2,0); } 
            for(int i = 0; i<=5; i++) {MapBuilder.Wall(g,10+i,1,10,5-i,2,0); } 
            for(int i = 0; i<=5; i++) {MapBuilder.Wall(g,20+i,1,10,7-i,2,0); } 
            
            new Goal(g,90,190);
            AI_Test_Map = "Initialized";
        }
        else {
            for (Box box : Box.Box) { box.redraw(g, box.getCordX(), box.getCordY());}
        }
    }
    
}
