package thecyberplanners.labyrinthine;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
public class MainComponent extends SimpleApplication {
	
	public static void main(String[] args) {
		AppSettings settings = new AppSettings(true);
		settings.setResolution(640, 480);
		MainComponent app = new MainComponent();
		app.setSettings(settings);
		app.setShowSettings(false);
		app.start();
	}
	
	@Override
	public void simpleInitApp() {
		flyCam.setMoveSpeed(50);
		rootNode.attachChild(createBox("Main room", 1,1,1,ColorRGBA.Blue));
		rootNode.attachChild(createBox("Room 1", 1, 1, 1, ColorRGBA.Orange).move(2f, 0, 0));
		rootNode.attachChild(createBox("Room 2", 1, 1, 1, ColorRGBA.Orange).move(-2f, 0, 0));
		rootNode.attachChild(createBox("Room 3", 1, 1, 1, ColorRGBA.Orange).move(2f, 0, 2f));
		rootNode.attachChild(createBox("Room 4", 1, 1, 1, ColorRGBA.Orange).move(2f, 0, -2f));
		rootNode.attachChild(createBox("Room 5", 1, 1, 1, ColorRGBA.Orange).move(0, 0, 2f));
		rootNode.attachChild(createBox("Room 6", 1, 1, 1, ColorRGBA.Orange).move(0, 0, -2f));
		rootNode.attachChild(createBox("Room 7", 1, 1, 1, ColorRGBA.Orange).move(-2f, 0, 2f));
		rootNode.attachChild(createBox("Room 8", 1, 1, 1, ColorRGBA.Orange).move(-2f, 0, -2f));
	}

	private Spatial createBox(String string, int i, int j, int k, ColorRGBA color) {
		Geometry box = new Geometry(string, new Box(i, j, k));
		Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		material.setColor("Color", color);
		box.setMaterial(material);
		return box;
	}
}