package com.supercoolnamespace.hackgame;

import android.util.Log;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
	private static final String TAG = MainActivity.class.getSimpleName();
	
	private SurfaceHolder surfaceHolder;
	private MainGamePanel gamePanel;

	public MainThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel) {
	 super();
	 this.surfaceHolder = surfaceHolder;
	 this.gamePanel = gamePanel;
	}
	
	// flag to hold game state
	private boolean running;

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		long tickCount = 0;
		Log.d(TAG, "Starting game loop");
		while (running) {
			tickCount++;
			// update game state
			// render state to the screen
		}
		Log.d(TAG, "Gameloop executed " + tickCount + " times.");
	}
}