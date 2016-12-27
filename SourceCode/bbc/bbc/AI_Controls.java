/*
 *      Seperate file containing the controls Alce can use to play this game to reduce clutter #ObjectOriented
 */
package bbc;

/**
 *
 * @author Bryce
 */
public class AI_Controls {
    public AI_Controls() {}
    
    /**
     *      Setup for the player controls for Alice
     * @param xoy - X or Y
     * @param dir - direction  (n,s,e,w)
     */
    protected static void control(char xoy, String dir){
        if ( xoy == AI_Player.x ) {
            if ( dir.equals(AI_Player.LEFT) ) {
                Controls.manipulateX(Controls.collisionDetection(AI_Player.LEFT)); 
                check(Panel.getPlayerX(), Panel.getPlayerY());
            }
            else if ( dir.equals(AI_Player.RIGHT) ) {
                Controls.manipulateX(Controls.collisionDetection(AI_Player.RIGHT)); 
                check(Panel.getPlayerX(), Panel.getPlayerY());
            }
            else{
                System.out.println("Unrecognized dir input error");
            }
        }
        else if ( xoy == AI_Player.y ) {
            if ( dir.equals(AI_Player.UP) ) {
                Controls.manipulateY(Controls.collisionDetection(AI_Player.UP)); 
                check(Panel.getPlayerX(), Panel.getPlayerY());
            }
            else if  ( dir.equals(AI_Player.DOWN) ) {
                Controls.manipulateY(Controls.collisionDetection(AI_Player.DOWN)); 
                check(Panel.getPlayerX(), Panel.getPlayerY());
            }
            else {
                System.out.println("Unrecognized dir input error");
            }
        }
        else{
            System.out.println("Unrecognized XOY input error");
        }
    }
   
    /**
     *      Records spaces that have already been visited
     * @param x - X cord of space visited
     * @param y - Y cord of space visited
     */
    public static void check(int x, int y){
        AI_Player.checkedX.add(x);
        AI_Player.checkedY.add(y);
    }
    
    /**
     *      Checks if a cord pair has been checked before
     * @param x - x cord to be checked
     * @param y - y cord to be checked
     * @return - boolean value of if the cord has been visited or not
     */
    public static boolean wasChecked(int x, int y){
        boolean hasBeenHereX = false;
        boolean hasBeenHereY = false;
        int xFoundAt = 0;
        int YFoundAt = 0;
        if (!AI_Player.checkedX.isEmpty()){
        for(int i : AI_Player.checkedX){
            if( i == x ) { hasBeenHereX = true; }
        }
        for( int i : AI_Player.checkedY ) {
            if( i == x ) { hasBeenHereY = true; }
        }
       
        if( hasBeenHereX && hasBeenHereX==hasBeenHereY ) { return hasBeenHereX; }
    }
        return false;
    }
    
    
}
