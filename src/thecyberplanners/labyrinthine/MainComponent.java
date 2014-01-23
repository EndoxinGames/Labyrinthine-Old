package thecyberplanners.labyrinthine;

import java.util.Random;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

import de.lessvoid.nifty.Nifty;

public class MainComponent extends SimpleApplication {
	
	public static final int RENDER_DISTANCE = 10;
	public static final int SCALE = 2;
	public static final double ROOM_FREQUENCY = 0.0025;
	
	public static final boolean ENABLE_3D_GEN = true;
	
	public static void main(String[] args) {
		AppSettings settings = new AppSettings(true);
		settings.setResolution(640, 480);
		MainComponent app = new MainComponent();
		app.setSettings(settings);
		app.setShowSettings(false);
		app.setDisplayStatView(false);
		app.setDisplayFps(false);
		app.start();
	}
	
	@Override
	public void simpleInitApp() {
		flyCam.setMoveSpeed(50);
		rootNode.attachChild(createBox("Main room", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Blue));
		rootNode.attachChild(createBox("Room 1", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Orange).move(2f, 0, 0));
		rootNode.attachChild(createBox("Room 2", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Orange).move(-2f, 0, 0));
		rootNode.attachChild(createBox("Room 3", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Orange).move(2f, 0, 2f));
		rootNode.attachChild(createBox("Room 4", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Orange).move(2f, 0, -2f));
		rootNode.attachChild(createBox("Room 5", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Orange).move(0, 0, 2f));
		rootNode.attachChild(createBox("Room 6", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Orange).move(0, 0, -2f));
		rootNode.attachChild(createBox("Room 7", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Orange).move(-2f, 0, 2f));
		rootNode.attachChild(createBox("Room 8", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Orange).move(-2f, 0, -2f));
		
		Random random = new Random();
		for (int x = -RENDER_DISTANCE*16; x <= 16*RENDER_DISTANCE; x++) {
			for (int z = -RENDER_DISTANCE*16; z <= 16*RENDER_DISTANCE; z++) {
				if (ENABLE_3D_GEN) {
					for (int y = -RENDER_DISTANCE*16; y <= 16*RENDER_DISTANCE; y++) {
						if ((Math.abs(random.nextDouble() % 100)) < ROOM_FREQUENCY && !((x >= -1 && x <= 1) && (z <= 1 && z >= -1))) {
							int num = Math.abs(random.nextInt() % 3);
							switch (num) {
								case 1:
									rootNode.attachChild(createBox("Random Box Type 1", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Magenta).move(x * SCALE, y * SCALE, z * SCALE));
									break;
								case 2:
									rootNode.attachChild(createBox("Random Box Type 2", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.DarkGray).move(x * SCALE, y * SCALE, z * SCALE));
									break;
								case 0:
									rootNode.attachChild(createBox("Random Box Type 3", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Yellow).move(x * SCALE, y * SCALE, z * SCALE));
									break;
								default:
									rootNode.attachChild(createBox("Error Box", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Red).move(x * SCALE, y * SCALE, z * SCALE));
									break;
							}
						}
					}
				} else {
					if ((Math.abs(random.nextDouble() % 100)) < ROOM_FREQUENCY && !((x >= -1 && x <= 1) && (z <= 1 && z >= -1))) {
						int num = Math.abs(random.nextInt() % 3);
						switch (num) {
							case 1:
								rootNode.attachChild(createBox("Random Box Type 1", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Magenta).move(x * SCALE, 0, z * SCALE));
								break;
							case 2:
								rootNode.attachChild(createBox("Random Box Type 2", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.DarkGray).move(x * SCALE, 0, z * SCALE));
								break;
							case 0:
								rootNode.attachChild(createBox("Random Box Type 3", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Yellow).move(x * SCALE, 0, z * SCALE));
								break;
							default:
								rootNode.attachChild(createBox("Error Box", SCALE / 2, SCALE / 2, SCALE / 2, ColorRGBA.Red).move(x * SCALE, 0, z * SCALE));
								break;
						}
					}
				}
			}
		}
		
		NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
		Nifty nifty = niftyDisplay.getNifty();
		MainMenu ss = new MainMenu(this);
		stateManager.attach(ss);
		nifty.fromXml("Interfaces/screen.xml", "start", ss);
		guiViewPort.addProcessor(niftyDisplay);
		flyCam.setDragToRotate(true);
	}
	
	private Spatial createBox(String string, int i, int j, int k, ColorRGBA color) {
		Geometry box = new Geometry(string, new Box(i, j, k));
		Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		material.setColor("Color", color);
		box.setMaterial(material);
		return box;
	}
	@Override
	public void simpleUpdate(float tpf) {
		Vector3f v = cam.getLocation();
		System.out.println("Camera is at " + v.toString());
	}
}
