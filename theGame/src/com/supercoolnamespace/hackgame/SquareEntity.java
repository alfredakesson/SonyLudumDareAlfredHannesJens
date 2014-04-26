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
	Bitmap bitmap; 
	private static final String TAG = MainActivity.class.getSimpleName();


	public SquareEntity(Context ctx, float x, float y) {
		this.x = x;
		this.y = y;
		bitmap = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.blue_square);
	}

	@Override
	public void draw(Canvas c) {
		
		c.drawBitmap (bitmap, x, y, null);
		//c.drawRect(10,10,10,10, new Paint(10));
		//Log.d(TAG, "drawing an entity");
	}

}
