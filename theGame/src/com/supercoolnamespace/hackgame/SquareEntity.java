package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

public class SquareEntity extends Entity {
	private float fill = 200;
	Bitmap bitmap;
	private boolean drawTheScreen = true;
	private static final String TAG = MainActivity.class.getSimpleName();

	public SquareEntity(Context ctx, float x, float y) {
		super(x, y);
		bitmap = BitmapFactory.decodeResource(ctx.getResources(),
				R.drawable.blue_square);
	}

	@Override
	public void draw(Canvas c) {
		if (drawTheScreen)
			c.drawBitmap(bitmap, x, fill + y, null);
		Log.d(TAG, "y+fill: " + (fill + y));
		// c.drawRect(10,10,10,10, new Paint(10));
		// Log.d(TAG, "drawing an entity");
	}

	public void update(float stepSize) {
		fill += stepSize;
	}

	public void hide() {
		drawTheScreen = false;

	}

	public boolean isPressed(Point hitPt) {
		
		int height= bitmap.getHeight();
		int width = bitmap.getWidth();
		
		int yHit = hitPt.y;
		int xHit = hitPt.x;
		
		if(xHit < x) {
			Log.d(TAG, "is pressed? 1");			
			return false;
		}
		else if(xHit > x + height) {
			Log.d(TAG, "is pressed? 2");
			return false;
		}
		else if(yHit < y) {
			Log.d(TAG, "is pressed? 3");			
			return false;
		}
		else if(yHit > y + width) {
			Log.d(TAG, "is pressed? 4");
			return false;
		}
		else
			Log.d(TAG, "is pressed? TRUE");
			return true;
	}
}
