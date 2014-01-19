package thecyberplanners.labyrinthine;

import java.util.logging.Level;


public class Game {
	public Game(){
		
	}
	
	public void input(){
	}
	
	public void update(){
		if(Input.getMouseDown(0)) Main.log(Level.SEVERE, "Left");
		if(Input.getMouseDown(1)) Main.log(Level.SEVERE, "Right");
		if(Input.getMouseUp(0)) Main.log(Level.SEVERE, "Left");
		if(Input.getMouseUp(1)) Main.log(Level.SEVERE, "Right");
	}
	
	public void render(){
		
	}
}
