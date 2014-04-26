package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.SurfaceView;

public class SquareEntity extends Entity {
	private SurfaceView surfaceView;
	private float offset;
	private float fill = 400;
	Bitmap bitmap; 
	private static final String TAG = MainActivity.class.getSimpleName();


	public SquareEntity(Context ctx, float x, float y) {
		super(x,y);
		bitmap = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.blue_square);
	}

	@Override
	public void draw(Canvas c) {
		c.drawBitmap (bitmap, x, fill+y, null);
		Log.d(TAG, "y+fill: " + y+fill);
		//c.drawRect(10,10,10,10, new Paint(10));
		//Log.d(TAG, "drawing an entity");
	}
	
	public void update(float stepSize) {
		fill+= stepSize;
	}

}
