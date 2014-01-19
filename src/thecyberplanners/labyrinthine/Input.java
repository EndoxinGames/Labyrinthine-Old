package thecyberplanners.labyrinthine;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input {
	
	public static final int NUM_KEYS = 256;
	public static final int NUM_MOUSE_BUTTONS = 5;
	private static ArrayList<Integer> keys = new ArrayList<Integer>();
	private static ArrayList<Integer> downKeys = new ArrayList<Integer>();
	private static ArrayList<Integer> upKeys = new ArrayList<Integer>();
	
	private static ArrayList<Integer> mice = new ArrayList<Integer>();
	private static ArrayList<Integer> downMouse = new ArrayList<Integer>();
	private static ArrayList<Integer> upMouse = new ArrayList<Integer>();
	
	public static boolean getKey(int keyCode) {
		return Keyboard.isKeyDown(keyCode);
	}
	
	public static boolean getKeyDown(int keyCode) {
		return downKeys.contains(keyCode);
	}
	
	public static boolean getKeyUp(int keyCode) {
		return upKeys.contains(keyCode);
	}
	
	public static boolean getMouse(int keyCode){
		return Mouse.isButtonDown(keyCode);
	}
	
	public static boolean getMouseDown(int button){
		return downMouse.contains(button);
	}
	
	public static boolean getMouseUp(int button){
		return upMouse.contains(button);
	}
	
	public static void update() {
		upKeys.clear();
		for (int i = 0; i < NUM_KEYS; i++) {
			if (!getKey(i) && keys.contains(i)) {
				upKeys.add(i);
			}
		}
		
		downKeys.clear();
		
		for (int i = 0; i < NUM_KEYS; i++) {
			if (getKey(i) && !keys.contains(i)) {
				downKeys.add(i);
			}
		}
		keys.clear();
		for (int i = 0; i < NUM_KEYS; i++) {
			if (getKey(i)) {
				keys.add(i);
			}
		}
		
		
		
		upMouse.clear();
		for (int i = 0; i < NUM_MOUSE_BUTTONS; i++) {
			if (!getMouse(i) && mice.contains(i)) {
				upMouse.add(i);
			}
		}
		
		downMouse.clear();
		
		for (int i = 0; i < NUM_MOUSE_BUTTONS; i++) {
			if (getMouse(i) && !mice.contains(i)) {
				downMouse.add(i);
			}
		}
		mice.clear();
		for (int i = 0; i < NUM_MOUSE_BUTTONS; i++) {
			if (getKey(i)) {
				mice.add(i);
			}
		}
	}
}
