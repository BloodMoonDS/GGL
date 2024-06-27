/**
 * 
 */
package com.bloodiey.GGL;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JOptionPane;

/**
 * 
 */
public class Input implements KeyListener, MouseListener,MouseMotionListener, MouseWheelListener {
	
	

	private GameLoop gc;
	public ExceptionHandler EH = new ExceptionHandler();
	private final int NUM_KEYS = 256;
	private boolean[] keys =  new boolean[NUM_KEYS];
	private boolean[] keysLast =  new boolean[NUM_KEYS];
	
	private final int NUM_BUTTONS = 9;
	private boolean[] buttons =  new boolean[NUM_BUTTONS];
	private boolean[] buttonsLast =  new boolean[NUM_BUTTONS];
	private int mouseX,mouseY;
	private int scroll;
	
	public Input(GameLoop gc) {
		this.gc = gc;
		mouseX = 0;
		mouseY = 0; 
		scroll = 0;
		
		gc.getWindow().getCanvas().addKeyListener(this);
		gc.getWindow().getCanvas().addMouseMotionListener(this);
		gc.getWindow().getCanvas().addMouseListener(this);
		gc.getWindow().getCanvas().addMouseWheelListener(this);
	}
	public void update() {
		scroll = 0;
		
		for(int i = 0; i < NUM_KEYS; i++) {
			keysLast[i] = keys[i];
			
		}
		for(int i = 0; i < NUM_BUTTONS; i++) {
			buttonsLast[i] = buttons[i];
			
		}
	}
	
	public boolean isKey(int KeyCode) {
		
		return keys[KeyCode];
	}
	public boolean isKeyDown(int KeyCode) {
		
		return keys[KeyCode] && !keysLast[KeyCode];
	}
	public boolean isKeyUp(int KeyCode) {
		
		return !keys[KeyCode] && keysLast[KeyCode];
	}
	public boolean isButton(int button) {
		
		return buttons[button];
	}
	public boolean isisButtonDown(int button) {
		
		return buttons[button] && !buttonsLast[button];
	}
	public boolean isisButtonUp(int button) {
		
		return !buttons[button] && buttonsLast[button];
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	
	public void mouseClicked(MouseEvent e) {
		try {
			buttons[e.getButton()] = true;
			}catch(ArrayIndexOutOfBoundsException e1){
				JOptionPane.showMessageDialog(null, "ERROR: "+ e1 + "\n (I can't recognize that mouse button)");
				FileSaver sav = new FileSaver();
				sav.Writefile("Input Exception", "Exception: " + e1);
				//e1.printStackTrace();
			}
	}

	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			buttons[e.getButton()] = true;
			}catch(ArrayIndexOutOfBoundsException e1){
				JOptionPane.showMessageDialog(null, "ERROR: "+ e1 + "\n (I can't recognize that mouse button)");
				FileSaver sav = new FileSaver();
				sav.Writefile("Input Exception", "Exception: " + e1);
				//e1.printStackTrace();
			}
		
	}

	
	public void mouseReleased(MouseEvent e) {
		try {
			buttons[e.getButton()] = true;
			}catch(ArrayIndexOutOfBoundsException e1){
				JOptionPane.showMessageDialog(null, "ERROR: "+ e1 + "\n (I can't recognize that mouse button)");
				//e1.printStackTrace();
			}
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		scroll = e.getWheelRotation();
	}

	
	public void mouseDragged(MouseEvent e) {
		mouseX = (int)(e.getX() / gc.getScale());
		mouseY = (int)(e.getY() / gc.getScale());
	}

	
	public void mouseMoved(MouseEvent e) {
		mouseX = (int)(e.getX() / gc.getScale());
		mouseY = (int)(e.getY() / gc.getScale());
	}
	public int getMouseX() {
		return mouseX;
	}
	public int getMouseY() {
		return mouseY;
	}
	public int getScroll() {
		return scroll;
	}

}
