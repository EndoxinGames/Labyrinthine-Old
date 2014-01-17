package theCyberPlanners.labrynthean;

public class Main {
        
        public static final int WIDTH = 800;
        public static final int HIEGHT = 600;
        public static final String TITLE = "Labrynthean Game Engine";

        public static void main(String[] args) {
                Window.createWindow(WIDTH, HIEGHT, TITLE);
                Main game = new Main();
                game.start();
        }
        
        public Main(){
                
        }
        
        public void start(){
                run();
        }
        
        public void stop(){
                
        }
        
        public void run(){
                while(!Window.isCloseRequested()){
                        render();
                }
        }
        
        public void render(){
                Window.render();
        }
        
        public void cleanUp(){
                
        }
        
}
