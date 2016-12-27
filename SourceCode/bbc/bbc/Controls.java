/*
 * Responsible for all of the game type controls - takes in key input and controls accordingly
 */
package bbc;

import java.awt.event.KeyEvent;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Scanner;
/**
 *
 * @author Bryce, Billy
 */
public class Controls {
    private final static int size = Panel.cloneSize();
    static int mi = Panel.mi; //Movement increment
    static ArrayList<ArrayList<Integer>> theFiefdom = new ArrayList<>(); //first dimension is x, second dimension is y, think the battleship proj and this is that String[][] thing
    Scanner input = new Scanner(System.in);
    
    public Controls() {
        int ke = KeyEvent.VK_K;
        keyPressed(ke); 
    }
    
    /**
     *      Controls for moving player with corresponding values and limitations
     *
     * @param ke - current key event
     */
    static void keyPressed(int ke) {
        int i = ke;
        switch (i) {
            case KeyEvent.VK_W:
                manipulateY(collisionDetection("n"));
                break;
            case KeyEvent.VK_A:
                manipulateX(collisionDetection("w"));
                break;
            case KeyEvent.VK_S:
                manipulateY(collisionDetection("s"));
                break;
            case KeyEvent.VK_D:
                manipulateX(collisionDetection("e"));
                break;
            //AI case
            case KeyEvent.VK_K:
                break;
            default:
                break;
        }
        Goal.winEvent(Goal.isWin()); //Checks if game is won or nah
    }

    /**
     *      Allows for manipulation of Y value
     *
     * @param m - the amount to change 'Y' by
     */
    public static void manipulateY(int m) {
        if(Panel.y+m < Panel.MAX_HEIGHT && Panel.y+m >= Panel.MIN_HEIGHT)
        { Panel.y += m; }
        else
        { out.println("Out of Bounds"); }
    }

    /**
     *      Allows for manipulation of X value
     *
     * @param m - the amount to change 'X' by
     */
    public static void manipulateX(int m) {
        if(Panel.x+m < Panel.MAX_WIDTH && Panel.x+m >= Panel.MIN_WIDTH)
        { Panel.x += m; }
        else
        { out.println("Out of Bounds"); }
    }

    /**
     *      Updates the Fiefdom, enough said.
     */
    public void ruleTheFiefdom() {
        for (int x = 0; x <= Panel.MAX_WIDTH; x += mi) {
            for (int y = 0; y <= Panel.MAX_HEIGHT; y += mi) { // 0 = nothing, 1 = avatar, 2 = box, 3+ = whatever shape we implement next
                ArrayList<Integer> randomFief = new ArrayList<>();
                
            }
        }
    }
    
    /**
     *      Checks for the amount of spaces that can be moved before collision, with the max being the set movement increment
     *
     * @param dir Specifies the direction to calculate movement for
     * @return the amount that can be traversed in the requested direction before collision
     */
    public static int collisionDetection(String dir) { //Uses dir to find out which direction it applies movement increment for the return
                                                        //Also checks how far can be traversed in the requested direction before collisions
        
        //if I make it modify movement increment for evening up along the grid i'd change mi here according to X and Y position so that in the direction
        //specified max movement is set to whatever it takes to get back on grid, then at the end of this method I would rechange it back to 10
        
        
        int crusadeIntensity = 0; //The amount you get to crusade across your fiefdom before running into peasants or other obstacles and wastes of space.
        int[][] frontLine = {{0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0}}; //only 8 values because you can touch walls but not go into them, this way sides won't register collisions if traversing along a wall.
        int[][] enemyLine = {{0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0}, {0,0}}; //10 values for collision handling
        
        boolean canCrusadeTenFiefs = true; //until vicinity is done I can't use the whole partial moving thing
        int efficiency = 0;
        switch(dir) { //first for loop gets the values for the side transversing, second one moves it a unit at a time until collision with a square in the vicinity (whole map for now)
            case "n": //W, UPWARDS, TO THE HEAVENS
                for (int i = 0; i < size - 2; i++) { //dealing with 2 less points than the length of a side
                    frontLine[i][0] = Panel.x + i;
                    frontLine[i][1] = Panel.y;
                }
                for (int a = 0; a < mi; a++) { //you can touch a wall, so you only need to be clear for one less than the mi
                    for (Box enemyOfTheFiefdom : Box.Box) { //checks to see if the new frontLine has crusaded into an enemy
                        for (int c = 0; c < enemyOfTheFiefdom.getWidth(); c++) {
                            enemyLine[c][0] = enemyOfTheFiefdom.getCordX() + c;
                            enemyLine[c][1] = enemyOfTheFiefdom.getCordY() + 10;
                        }
                        for (int d = 0; d < frontLine.length; d++) {
                            for (int e = 0; e < enemyLine.length; e++) {
                                if (frontLine[d][0] == enemyLine[e][0] && frontLine[d][1] == enemyLine[e][1]) {
                                    canCrusadeTenFiefs = false;
                                    crusadeIntensity++;
                                }
                                efficiency++;
                            }
                        }
                    }
                    for (int b = 0; b < frontLine.length; b++) { //increment the frontLine one unit
                        frontLine[b][1]--;
                    }
                }
                break;
            case "w": //A, WESTWARDS
                for (int i = 0; i < size - 2; i++) {
                    frontLine[i][0] = Panel.x;
                    frontLine[i][1] = Panel.y + i; //who thought it made sense in GUI's to make positive incrementation of Y go down? - Gaben probably, he lives life on the edge
                }
                for (int a = 0; a < mi; a++) {
                    for (Box enemyOfTheFiefdom : Box.Box) { //checks to see if the new frontLine has crusaded into an enemy
                        for (int c = 0; c < enemyOfTheFiefdom.getHeight(); c++) {
                            enemyLine[c][0] = enemyOfTheFiefdom.getCordX() + 10;
                            enemyLine[c][1] = enemyOfTheFiefdom.getCordY() + c;
                        }
                        for (int d = 0; d < frontLine.length; d++) {
                            for (int e = 0; e < enemyLine.length; e++) {
                                if (frontLine[d][0] == enemyLine[e][0] && frontLine[d][1] == enemyLine[e][1]) {
                                    canCrusadeTenFiefs = false;
                                    crusadeIntensity++;
                                }
                            }
                        }
                    }
                    for (int b = 0; b < frontLine.length; b++) { //increment the frontLine one unit
                        frontLine[b][0]--;
                    }
                }
                break;
            case "s": //S, DOWNWARDS, TO HELL WE GO!
                for (int i = 0; i < size - 2; i++) {
                    frontLine[i][0] = Panel.x + i;
                    frontLine[i][1] = Panel.y + 10; //who thought it made sense in GUI's to make positive incrementation of Y go down?
                }
                for (int a = 0; a < mi; a++) {
                    for (Box enemyOfTheFiefdom : Box.Box) { //checks to see if the new frontLine has crusaded into an enemy
                        for (int c = 0; c < enemyOfTheFiefdom.getWidth(); c++) {
                            enemyLine[c][0] = enemyOfTheFiefdom.getCordX() + c;
                            enemyLine[c][1] = enemyOfTheFiefdom.getCordY();
                        }
                        for (int d = 0; d < frontLine.length; d++) {
                            for (int e = 0; e < enemyLine.length; e++) {
                                if (frontLine[d][0] == enemyLine[e][0] && frontLine[d][1] == enemyLine[e][1]) {
                                    canCrusadeTenFiefs = false;
                                    crusadeIntensity++;
                                }
                            }
                        }
                    }
                    for (int b = 0; b < frontLine.length; b++) { //increment the frontLine one unit
                        frontLine[b][1]++;
                    }
                }
                break;
            case "e": //D, EASTWARDS
                for (int i = 0; i < size - 2; i++) {
                    frontLine[i][0] = Panel.x + 10;
                    frontLine[i][1] = Panel.y + i; //who thought it made sense in GUI's to make positive incrementation of Y go down?
                }
                for (int a = 0; a < mi; a++) {
                    for (Box enemyOfTheFiefdom : Box.Box) { //checks to see if the new frontLine has crusaded into an enemy
                        for (int c = 0; c < enemyOfTheFiefdom.getHeight(); c++) {
                            enemyLine[c][0] = enemyOfTheFiefdom.getCordX();
                            enemyLine[c][1] = enemyOfTheFiefdom.getCordY() + c;
                        }
                        for (int d = 0; d < frontLine.length; d++) {
                            for (int e = 0; e < enemyLine.length; e++) {
                                if (frontLine[d][0] == enemyLine[e][0] && frontLine[d][1] == enemyLine[e][1]) {
                                    canCrusadeTenFiefs = false;
                                    crusadeIntensity++;
                                }
                            }
                        }
                    }
                    for (int b = 0; b < frontLine.length; b++) { //increment the frontLine one unit
                        frontLine[b][0]++;
                    }
                }
                break;
        }
        //out.println(efficiency);  //for looking at how disgusting this algorithm is (fixed for the most part)
        if (canCrusadeTenFiefs) {
            if (dir.equals("e") || dir.equals("s")) {
                return 10;
            }
            else if (dir.equals("w") || dir.equals("n")){
                return -10;
            }
        }
        return 0;
    }


    public static JPanel getCurrentPanel() {
        return Panel.p;
    }
}
