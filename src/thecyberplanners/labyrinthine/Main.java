package thecyberplanners.labyrinthine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

public class Main {
        
        public static final int WIDTH = 800;
        public static final int HIEGHT = 600;
        public static final String TITLE = "Labrynthean Game Engine";
        
        public boolean running;
        
        public static void main(String[] args) {
                Window.createWindow(WIDTH, HIEGHT, TITLE);
                Main game = new Main();
                if(Boolean.getBoolean(args[0])){
                        setLevel(Level.ALL);
                }else{
                        setLevel(Level.INFO);
                }
                game.start();
        }
        
        public Main() {
                running = false;
        }
        
        public void start() {
                if(running) return;
                run();
        }
        
        public void stop() {
                if(!running) return;
                running = false;
        }
        
        private void run() {
                running = true;
                while (running) {
                        render();
                        if(Window.isCloseRequested()){
                                stop();
                        }
                }
                cleanUp();
        }
        
        private void render() {
                Window.render();
        }
        
        private void cleanUp() {
                Window.dispose();
        }
        
        public static Level level;
        
        public static void setLevel(Level level) {
                Main.level = level;
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