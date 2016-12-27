/*
* Class to solve the maze like a person would, only Harder...Better...Faster...Stronger
    It works it Harder
        Makes it better
            Does it faster
                Gets it Stronger
                More than ever
            Hour(s) after
        This AI('s) work's
    Never over
-DankPunk
 */
package bbc;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Bryce
 */
public class AI_Player {
    protected static final String thisIsYourNameAI = "Alice"; //A_Lovely_Intelligent_Cognitive_Environment 
    protected static final String AI_TEST_MAP = "AITestMap";
    //Movement
    protected static final char x = 'x';
    protected static final char y = 'y';
    protected static final String UP = "n";
    protected static final String DOWN = "s";
    protected static final String LEFT = "w";
    protected static final String RIGHT = "e";
    //Usage check sums
    protected static boolean usingAI = false;
    protected static boolean Finished = false;
    protected static boolean firstRun = true;
    //Directional Memory
    protected static boolean dontGoUp = false;
    protected static boolean dontGoRight = false;
    protected static boolean dontGoLeft = false;
    protected static boolean dontGoDown = false;
    protected static String lastMoveLR = "";
    protected static String lastMoveUD = "";
    protected static boolean FixerL = true;
    protected static boolean FixerR = true;
    protected static String dirMode = "";
    //Recording what has already been checked
    protected static ArrayList<Integer> checkedX = new ArrayList<>();
    protected static ArrayList<Integer> checkedY = new ArrayList<>();
    
    public AI_Player(Graphics g){
    }
    
    /**
     *      Play method for Alice, allows her to virtually press keys and provides logic to move the player
     */
    public static void AIplay(){    //make this so it figures out where the middle is and works towards it from what side it is on (this model is assuming exit is down)
            // DOWN
            if(Controls.collisionDetection(DOWN) != 0 && !lastMoveUD.equals(UP)){
                    AI_Controls.control(y, DOWN);
                    System.out.println("DOWN");
                    AI_Controls.check(Panel.getPlayerX(), Panel.getPlayerY());
                    lastMoveUD = DOWN;
                    FixerL = true;
                    FixerR = true;
                } 
            //RIGHT
            else if(Controls.collisionDetection(RIGHT) != 0 && !lastMoveLR.equals(LEFT)){
                    AI_Controls.control(x, RIGHT);
                    System.out.println("RIGHT");
                    AI_Controls.check(Panel.getPlayerX(), Panel.getPlayerY());
                    lastMoveLR = RIGHT;
                    FixerL = true;
                    FixerR = true;
                } 
            //LEFT
            else if(Controls.collisionDetection(LEFT) != 0 && !lastMoveLR.equals(RIGHT)){
                    AI_Controls.control(x, LEFT);
                    System.out.println("LEFT");
                    AI_Controls.check(Panel.getPlayerX(), Panel.getPlayerY());
                    lastMoveLR = LEFT;
                    FixerL = true;
                    FixerR = true;
                } 
            //UP
            else if(Controls.collisionDetection(UP) != 0 && !lastMoveUD.equals(DOWN)){
                    AI_Controls.control(y, UP);
                    System.out.println("UP");
                    AI_Controls.check(Panel.getPlayerX(), Panel.getPlayerY());
                    lastMoveUD = UP;
                    FixerL = true;
                    FixerR = true;
                } 
            //If stuck going right into a hole with a block to the down, left, and top after being locked out of going right again
            else if(Controls.collisionDetection(UP) == 0 && Controls.collisionDetection(LEFT) == 0 && Controls.collisionDetection(DOWN) == 0 && Controls.collisionDetection(RIGHT) != 0) {
                AI_Controls.control(x, RIGHT);
                lastMoveLR = RIGHT;
                
            }
            
            //If stuck going left into a hole with a block to the down, right, and top after being locked out of going left again
            else if(Controls.collisionDetection(UP) == 0 && Controls.collisionDetection(RIGHT) == 0 && Controls.collisionDetection(DOWN) == 0 && Controls.collisionDetection(LEFT) != 0) {
                AI_Controls.control(x, LEFT);
                lastMoveLR = LEFT;
                
            }
            
            // FIXER - if stuck
            else if(lastMoveLR.equals(LEFT) || lastMoveLR.equals(RIGHT)) {
                System.out.println("FIXER: "+FixerR+" "+FixerL);
                if (Controls.collisionDetection(RIGHT)==0 && Controls.collisionDetection(LEFT) != 0 && FixerL == true) {
                    AI_Controls.control(x, LEFT);
                    AI_Controls.check(Panel.getPlayerX(), Panel.getPlayerY());
                    lastMoveLR = LEFT;
                    FixerL = false;
                    System.out.println(FixerL+" L "+FixerR);
                    
                }
                else if (Controls.collisionDetection(LEFT)==0 && Controls.collisionDetection(RIGHT) != 0 && FixerR == true) {
                    AI_Controls.control(x, RIGHT);
                    AI_Controls.check(Panel.getPlayerX(), Panel.getPlayerY());
                    lastMoveLR = RIGHT;
                    FixerR = false;
                    System.out.println(FixerL+" R "+FixerR);
                }
            
                else if( Controls.collisionDetection(UP) != 0 || Controls.collisionDetection(DOWN) != 0) {
                    System.out.println("UD Fixer");
                    if(Controls.collisionDetection(UP) != 0) {
                        dirMode = UP;
                        
                    }
                    else {
                        dirMode = DOWN;
                    }
                    System.out.println("Dir Mode: "+dirMode);
                    if(Controls.collisionDetection(UP) != 0) {
                        System.out.println("Upppp");
                        FixerR = true;
                        FixerL = true;
                        AI_Controls.control(y, UP);
                        lastMoveUD = UP;
                        AI_Controls.check(Panel.getPlayerX(), Panel.getPlayerY());
                    }
                    else if(Controls.collisionDetection(DOWN) != 0) {
                        System.out.println("Downnn");
                        lastMoveUD = UP;
                        FixerR = true;
                        FixerL = true;
                        AI_Controls.control(y, DOWN);
                        lastMoveUD = DOWN;
                        AI_Controls.check(Panel.getPlayerX(), Panel.getPlayerY());
                    }
                    else {
                        System.out.println("gg");
                    }
                    
                }    
            }
            
            //Stuff to make Alice hit buttons
            if(!hasFinished() && !firstRun) { Frame.AIkeyPressed(); }
            else { System.out.println("Press any key in the window to begin" ); }
            firstRun = false;
        }
    
    /**
     *      Prepares the game environment for Alice to play
     * @param g - Graphics
     */
    protected static void prepareAiEnvironment(Graphics g){
        Maps.initializeMaps(g);
        Maps.loadMap(g, AI_TEST_MAP);
    }
    
    /**
     *      Allows the program to check if the player is human or nah ( Prove your not a robot)
     * @return usingAI - the boolean value of if an AI is playing
     */
    public static boolean isUsingAI()
    { return usingAI; }
    
    /**
     *      Sets the value of the boolean showing if an AI is in use
     * @param i - value to set the AI usage to
     */
    protected static void setUsingAI(boolean i)
    { usingAI = i; }
    
    /**
     *      Sets up the AI for use 
     * @param g - Graphics
     */
    public static void setup(Graphics g)
    {
        prepareAiEnvironment(g);
        setUsingAI(true);
    }
    
    /**
     *      Checks to see if the AI is finished
     * @return - Finished - if the AI has finished
     */
    public static boolean hasFinished(){
        return Finished;
    }
    
    /**
     *      Sets that the AI is finished ( upon win or other event )
     */
    public static void isFinished() {
        Finished = true;
    }
}
