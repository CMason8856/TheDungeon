/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Bryce
 */
public class Frame extends JFrame implements KeyListener {

    private JPanel frame;
    JPanel p = Panel.getCurrentPanel();

    public Frame() {
        super();
        frame = new Panel();
        add(frame);
        pack();
        addKeyListener(this);
        repaint();
    }

    public static void main(String[] args) {
        Frame window = new Frame();
        window.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setTitle("BBC");

    }

    @Override
    /**
     * Repaint an object (the player)
     */
    public void repaint() {
        super.repaint();
    }

    /**
     * Key pressed events
     *
     * @param ke - the current key event
     */
    public void keyPressed(KeyEvent ke) {
        Panel.keyPressed(ke);
        repaint();
    }

    @Override
    /**
     * Key typed event
     *
     * @param ke - the current key event
     */
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    /**
     * Key Released event
     *
     * @param ke - the current key event
     */
    public void keyReleased(KeyEvent ke) {
    }

}
