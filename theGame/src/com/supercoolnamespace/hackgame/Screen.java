package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

public abstract class Screen {

	protected Point displaySize;
	protected MainThread callback;

	public Screen(Context context, MainThread callback) {
		// Get the screen size of the device
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		displaySize = new Point();
		display.getSize(displaySize);
		
		this.callback = callback;
	}

	public abstract void touch(MotionEvent event);

	public abstract boolean isDead();

	public abstract void draw(Canvas c, float delta);
}
