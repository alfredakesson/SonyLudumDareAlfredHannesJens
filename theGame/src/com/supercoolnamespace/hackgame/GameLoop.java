package com.supercoolnamespace.hackgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;
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


		Tween.registerAccessor(Entity.class, new EntityTweener());
		// Tween.registerAccessor(SquareEntity.class, new EntityTweener());
		manager = new TweenManager();

		square = new SquareEntity(context, 0, 0);
		Tween.to(square, EntityTweener.POSITION_XY, 4f).target(100, 200)
				.start(manager);

		sunEntity = new SunEntity(768/2, 1280/2);
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
		
		sunEntity.setRotation(sunEntity.getRotation() + delta*0.1f);
		
		
		groundEntity.draw(c);

	}
	
	
	//not working yet!
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
