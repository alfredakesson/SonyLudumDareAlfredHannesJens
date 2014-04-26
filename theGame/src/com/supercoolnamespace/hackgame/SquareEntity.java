package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.SurfaceView;


public class SquareEntity extends Entity{
	private SurfaceView surfaceView;
	private Canvas c;
	private Drawable img;
	
	public SquareEntity(Canvas c, float x, float y) {
		this.c = c; 
		this.x = x; 
		this.y = y;
	}
	
	@Override
	public void draw(Context context) {
		 img = context.getResources().getDrawable(R.drawable.blue_square);
		Rect imageBounds = c.getClipBounds(); // Adjust this for where you
		img.setBounds(c.getClipBounds());
		img.draw(c);
	}

}
