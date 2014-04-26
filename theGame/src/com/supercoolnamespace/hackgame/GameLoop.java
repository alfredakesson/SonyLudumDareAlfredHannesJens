package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import entities.GroundEntity;
import entities.SunEntity;




public class GameLoop {
	private static final String TAG = MainActivity.class.getSimpleName();
	private TweenManager manager;
	private SquareEntity square;
	private Point displaySize;
	private SunEntity sunEntity;
	
	private GroundEntity groundEntity;

	public GameLoop(Context context) {

		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();

		displaySize = new Point();
		display.getSize(displaySize);
		
		Tween.registerAccessor(Entity.class, new EntityTweener());
		// Tween.registerAccessor(SquareEntity.class, new EntityTweener());
		manager = new TweenManager();

		square = new SquareEntity(context, 0, 0);
		
		float xMove = getMoveLengthX(square, 0.5f);
		float yMove = getMoveLengthY(square, 0.5f);
		
		Tween.to(square, EntityTweener.POSITION_XY, 4f).target(xMove, yMove)
				.start(manager);

		sunEntity = new SunEntity(displaySize.x/2, displaySize.y/2);
		groundEntity = new GroundEntity(200, 0, 100, 1600);

		/*Timeline.createSequence()
				.push(Tween.to(sunEntity, EntityTweener.POSITION_XY, 1f)
						.target(0, 400))
				.push(Tween.to(sunEntity, EntityTweener.POSITION_XY, 1f)
						.target(400, 800)).repeatYoyo(4, 0.0f).start(manager);*/

	}

	public void draw(Canvas c, float delta) {
		square.draw(c);
		manager.update(delta);
		sunEntity.setRotation(sunEntity.getRotation() + delta*0.1f);
		manager.update(0.01f);
		sunEntity.draw(c);
		
		
		groundEntity.draw(c);

	}
	
	
	//not working yet!
	public float getMoveLengthX(Entity e, float moveVal){
		Log.d(TAG, "getMoveLen + entityX = " + e.getX() + " entityY = " + e.getY()); 
		Log.d(TAG, "getMoveLen + dispSize = " + displaySize.x + " " + displaySize.y); 
		float normalizedSize = e.getX() / displaySize.x;
		//Log.d(TAG, "" + normalizedSize);
		return normalizedSize * moveVal;
	}
	
	public float getMoveLengthY(Entity e, float moveVal){
		float normalizedSize = e.getY() / displaySize.y;
		return normalizedSize * moveVal;
	}

}
