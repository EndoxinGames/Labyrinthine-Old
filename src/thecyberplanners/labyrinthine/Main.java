package thecyberplanners.labyrinthine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import org.newdawn.slick.util.Log;

public class Main {
	
	public static final int WIDTH = 800;
	public static final int HIEGHT = 600;
	public static final String TITLE = "Labrynthean Game Engine";
	public static final double FRAME_CAP = 5000.0;
	
	private boolean running;
	private Game game;
	
	public static void main(String[] args) {
		Window.createWindow(WIDTH, HIEGHT, TITLE);
		Main game = new Main();
		setLevel(Level.ALL);
		game.start();
	}
	
	public Main() {
		running = false;
		game = new Game();
	}
	
	public void start() {
		if (running) return;
		run();
	}
	
	public void stop() {
		if (!running) return;
		running = false;
	}
	
	private void run() {
		running = true;
		
		int frames = 0;
		long frameCounter = 0;
		
		long lastTime = Time.getTime();
		double unprossessedTime = 0;
		final double frameTime = 1.0 / FRAME_CAP;
		
		while (running) {
			boolean render = false;
			long currentTime = Time.getTime();
			long passedTime = currentTime - lastTime;
			lastTime = currentTime;
			
			unprossessedTime += passedTime / (double) Time.SECOND;
			frameCounter += passedTime;
			while (unprossessedTime >= frameTime) {
				render = true;
				unprossessedTime -= frameTime;
				if (Window.isCloseRequested()) {
					stop();
				}
				
				Time.setDelta(frameTime);
				Input.update();
				
				game.input();
				game.update();
				if (frameCounter >= Time.SECOND) {
					System.out.println(frames);
					frames = 0;
					frameCounter = 0;
				}
			}
			if (render) {
				render();
				frames++;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		cleanUp();
	}
	
	private void render() {
		game.render();
		Window.render();
	}
	
	private void cleanUp() {
		Window.dispose();
	}
	
	public static Level level;
	
	public static void setLevel(Level level) {
		Main.level = level;
		log(Level.INFO, "Level has been set to " + Main.level.getName());
	}
	
	public static void log(Level level, String msg) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("H:mm:ss");
		String message = "[" + format.format(date) + "] " + level.getName() + " - " + msg;
		if (Main.level.intValue() <= level.intValue()) {
			if (level.intValue() >= Level.WARNING.intValue()) {
				System.err.println(message);
			} else {
				System.out.println(message);
			}
		}
	}
	
}