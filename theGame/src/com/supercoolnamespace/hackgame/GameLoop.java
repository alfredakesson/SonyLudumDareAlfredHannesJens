package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class GameLoop {
	private static final String TAG = MainActivity.class.getSimpleName();
	private TweenManager manager;
	private SquareEntity square;
	private Point displaySize;

	public GameLoop(Context context) {

		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();

		Point displaySize = new Point();
		display.getSize(displaySize);
		
		Log.d(TAG, "displ size" + displaySize.x);

		Tween.registerAccessor(Entity.class, new EntityTweener());
		Tween.registerAccessor(SquareEntity.class, new EntityTweener());
		manager = new TweenManager();

		
		square = new SquareEntity(context, 50, 50);
		
		//float moveX = getMoveLengthX(square, 0.5f);
		//float moveY = getMoveLengthY(square, 0.5f);
		
		Tween.to(square, EntityTweener.POSITION_XY, 4f).target(100, 200)
				.start(manager);

	}

	public void draw(Canvas c, float delta) {
		square.draw(c);
		manager.update(delta);
	}
	
	
	
	public float getMoveLengthX(Entity e, float moveVal){
		Log.d(TAG, "getMoveLen " + e.getX());// + " " + displaySize.x); 
		float normalizedSize = e.getX() / displaySize.x;
		//Log.d(TAG, "" + normalizedSize);
		return normalizedSize * moveVal;
	}
	
	public float getMoveLengthY(Entity e, float moveVal){
		float normalizedSize = e.getY() / displaySize.y;
		return normalizedSize * moveVal;
	}

}
