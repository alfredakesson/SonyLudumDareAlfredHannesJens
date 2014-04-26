package com.supercoolnamespace.hackgame;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface Screen {
	public void touch(MotionEvent event);
	
	public boolean isDead();
	
	public void draw(Canvas c, float delta);
}
