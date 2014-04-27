package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

public class SquareEntity extends Entity {
	protected float fill = 200;
	public final static int BLUE = 0;
	public final static int RED = 1;
	Bitmap bitmap;
	private boolean drawTheScreen = true;
	private static final String TAG = MainActivity.class.getSimpleName();
	private int color;

	public SquareEntity(Context ctx, float x, float y, int color) {
		super(x, y);
		this.color = color;
		if(color == BLUE) {
			bitmap = BitmapFactory.decodeResource(ctx.getResources(),
					R.drawable.blue_square);			
		}
		else {
			bitmap = BitmapFactory.decodeResource(ctx.getResources(),
					R.drawable.red_square);
		}
	}
	

	@Override
	public void draw(Canvas c, Offset theDrawOffset) {
		if (drawTheScreen)
			c.drawBitmap(bitmap, x, getRealY(), null);//x + theDrawOffset.getOffset()
		Log.d(TAG, "y+fill: " + (getRealY()));
		// c.drawRect(10,10,10,10, new Paint(10));
		// Log.d(TAG, "drawing an entity");
	}

	public void update(float stepSize) {
		fill += stepSize;
	}

	public void hide() {
		drawTheScreen = false;

	}
	
	public boolean hidden(){
		return drawTheScreen;
	}

	public boolean isPressed(Point hitPt) {
		
		int height= bitmap.getHeight();
		int width = bitmap.getWidth();
		
		int yHit = hitPt.y;
		int xHit = hitPt.x;
		
		float realY = getRealY();
		
		if(xHit < x) {			
			return false;
		}
		else if(xHit > x + height) {
			return false;
		}
		else if(yHit < realY) {
			return false;
		}
		else if(yHit > realY + width) {
			return false;
		}
		else
			return true;
	}

	protected  float getRealY() {
		return y + fill;
	}
	
	public int getColor() {
		return color;
	}
}
