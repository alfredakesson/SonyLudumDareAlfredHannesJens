package com.supercoolnamespace.hackgame;

import intro.IntroScreen;

import java.util.Calendar;

import menu.MenuScreen;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class MainThread extends Thread {
	private static final String TAG = MainActivity.class.getSimpleName();

	private SurfaceHolder surfaceHolder;
	private MainGamePanel gamePanel;

	private GameLoop gameLoop;

	private Paint backgroundPaint;

	private IntroScreen introScreen;
	
	private Screen currentScreen;
	
	private Context context;

	public MainThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel) {
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;

		backgroundPaint = new Paint();
		backgroundPaint.setColor(Color.BLACK);

		gameLoop = new GameLoop(gamePanel.getContext());

		introScreen = new IntroScreen(gamePanel.getContext(), this);
		
		
		currentScreen = new MenuScreen(gamePanel.getContext(), this);
		
		context = gamePanel.getContext();

	}

	// flag to hold game state
	private boolean running;

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		long tickCount = 0;

		long oldTime = System.nanoTime();
		long deltaTime;
		Log.d(TAG, "Starting game loop");
		while (running) {
			tickCount++;
			// update game state
			// render state to the screen
			Canvas c = null;
			try {
				deltaTime = System.nanoTime() - oldTime;
				c = surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					if (c != null) {
						if(currentScreen == null){
							c.drawRect(0, 0, c.getWidth(), c.getHeight(),
									backgroundPaint);
							oldTime = System.nanoTime();
							gameLoop.draw(c, (float) deltaTime / 1000000000);
						}
						else if (!currentScreen.isDead()){
							oldTime = System.nanoTime();
							currentScreen.draw(c, (float) deltaTime / 1000000000);
						}

					} else {
						System.out.println("LOST FRAME");
					}

				}
			} finally {
				if (c != null) {
					surfaceHolder.unlockCanvasAndPost(c);
				}
			}
		}
		Log.d(TAG, "Gameloop executed " + tickCount + " times.");
	}
	
	public void goToMovie(){
		currentScreen = new IntroScreen(context, this);
	}
	
	public void goToGame(){
		currentScreen = gameLoop;
	}

	public void touch(MotionEvent event) {
		if(currentScreen == null){
			return;
		}
		
		if(!currentScreen.isDead()){
			currentScreen.touch(event);
		}
		
	}

}