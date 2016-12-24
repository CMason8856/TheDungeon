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

    public ObjectController(Graphics g, int x, int y) {

    }

    public static ObjectController getInstance() {
        return oc;
    }

    public static void InitializeBoxes(Graphics g) { //the ultimate ghetto singleton method (240 was actually useful :D)
        if (initializedBoxes == null) {
            Box a = new Box(g, 60, 50);
            Box b = new Box(g, 70, 50);
            Box c = new Box(g, 80, 50);
            Box d = new Box(g, 70, 40);
            Box e = new Box(g, 80, 30);
            initializedBoxes = "Initialized";
        }
        else {
            for (Box box : Box.Box) {
                box.redraw(g, box.getCordX(), box.getCordY());
            }
        }
    }
}
