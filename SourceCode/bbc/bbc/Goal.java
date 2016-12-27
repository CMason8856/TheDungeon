/*
 *      The Object one needs to find to win the game
 */
package bbc;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

/**
 *
 * @author Bryce
 */
public class Goal extends ObjectController{
    private static int x;
    private static int y;
    private static final int GOAL_SIZE = 9;
    private static final boolean isWin = true;
    
    public Goal(Graphics g, int x, int y) {
        super(g, x, y);
        this.x = x;
        this.y = y;
        g.setColor(Color.BLUE);
        g.drawRect(this.x, this.y, 9, 9);
    } 
    
    /**
     *      Checks if the game is won
     * @return bool value of if the game is won
     */
    public static boolean isWin()
    {
        if(Panel.getPlayerX() == x && Panel.getPlayerY() == y) 
        { return true; }
        else {return false;}
    }
    
    /**
     *      Keeps win in the redraw when updates occur
     * @param g 
     */
    public static void redraw(Graphics g)
    {
     g.setColor(Color.BLUE);
     g.drawRect(x, y, GOAL_SIZE, GOAL_SIZE);
    }
   
    /**
     *      This does not need to be separate but it allows us more versatility in determining what happens after the game is won
     * @param won - if won
     */
    public static void winEvent(boolean won)
    {
        Scanner input = new Scanner(System.in);
        if(won) {
            System.out.println("You win!! -Type any key to exit"); 
            AI_Player.isFinished();
            if(input.next()!=null) {
                System.exit(1);
            }
        }
    }
}
