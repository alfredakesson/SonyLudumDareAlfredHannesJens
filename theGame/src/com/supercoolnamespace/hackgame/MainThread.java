package com.supercoolnamespace.hackgame;

import java.util.Calendar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class MainThread extends Thread {
	private static final String TAG = MainActivity.class.getSimpleName();

	private SurfaceHolder surfaceHolder;
	private MainGamePanel gamePanel;
	
	private GameLoop gameLoop;
	
	private Paint backgroundPaint;



	public MainThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel) {
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
		
		
		
		backgroundPaint = new Paint();
		backgroundPaint.setColor(Color.BLACK);
		
		
		gameLoop = new GameLoop(gamePanel.getContext());
		
		
	}

	// flag to hold game state
	private boolean running;

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		long tickCount = 0;
		long oldTime; 
		long deltaTime;
		Log.d(TAG, "Starting game loop");
		while (running) {
			oldTime = Calendar.getInstance().getTimeInMillis();
			tickCount++;
			// update game state
			// render state to the screen
			Canvas c = null;
			try {
				deltaTime = Calendar.getInstance().getTimeInMillis() - oldTime;
				c = surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {	
					c.drawRect(0, 0, c.getWidth(), c.getHeight(), backgroundPaint);
					
					gameLoop.draw(c, deltaTime);

					
				}
			} finally {
				if (c != null) {
					surfaceHolder.unlockCanvasAndPost(c);
				}
			}
		}
		Log.d(TAG, "Gameloop executed " + tickCount + " times.");
	}
	


}