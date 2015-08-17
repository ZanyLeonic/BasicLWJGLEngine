package com.leonic.basiclwglengine;

import org.lwjgl.opengl.Display;

import com.leonic.basiclwglengine.engine.DisplayManager;
import com.leonic.basiclwglengine.engine.Loader;
import com.leonic.basiclwglengine.engine.RawModel;
import com.leonic.basiclwglengine.engine.Renderer;

public class MainGameLoop {

	/**
	 * 
	 * @param args
	 */
	public static void main(String [] args){
	
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		float[] vertices = { -0.5f, 0.5f, 0f, -0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f, 0.5f, 0.5f, 0f, -0.5f, 0.5f, 0f};
		
		RawModel model = loader.loadToVao(vertices);
		
		DisplayManager.setDisplayTitle("Basic LWJGL engine");
		while(!Display.isCloseRequested()){
			renderer.prepare();
			renderer.render(model);
			DisplayManager.updateDisplay();
		}
		
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
