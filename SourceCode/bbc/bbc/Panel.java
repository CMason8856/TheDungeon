/**
 *      Responsible for updating the screen as well as knowing the players position
 * @author Bryce, Billeh
 */
package bbc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private static int size = 10;
    static int x = 10;
    static int y = 10;
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
     *      calls paint method to update players model
     */
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    /**
     *      Paints the designated player object to a certain spot
     */
    public void paint(Graphics g) {
        if(!Maps.initialized()){
            
            System.out.println("AI?");
            Scanner input = new Scanner(System.in);
            
            if(input.next().equals("y")) { 
                AI_Player.setup(g); 
            }
            else{
                Maps.initializeMaps(g);
                Maps.selectMap(g);} 
            }
                Maps.loadMap(g, Maps.getCurrentMap()); 
                
                if(AI_Player.isUsingAI()) {
                    AI_Player.AIplay();
               
                }
        g.setColor(Color.red);
        g.drawRect(this.x, this.y, size - 1, size - 1);
    }
    
    /**
     *      So the win can match player cords with win cords
     * @return the x value of the player
     */
    public static int getPlayerX()
    {return x;}
    
    /**
     *      So the win can match player cords with win cords
     * @return the y value of the player
     */
    public static int getPlayerY()
    {return y;}
    
    /**
     *      Clones the value of size
     * @return - size
     */
    public static int cloneSize()
    {return size;}
    
}
