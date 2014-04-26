package com.supercoolnamespace.hackgame;

import entities.SunEntity;
import android.content.Context;
import android.graphics.Canvas;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class GameLoop {

	private TweenManager manager;
	private SquareEntity square;

	private SunEntity sunEntity;

	public GameLoop(Context context) {

		Tween.registerAccessor(Entity.class, new EntityTweener());
		// Tween.registerAccessor(SquareEntity.class, new EntityTweener());
		manager = new TweenManager();

		square = new SquareEntity(context, 0, 0);
		Tween.to(square, EntityTweener.POSITION_XY, 4f).target(100, 200)
				.start(manager);

		sunEntity = new SunEntity(400, 800);

		/*Timeline.createSequence()
				.push(Tween.to(sunEntity, EntityTweener.POSITION_XY, 1f)
						.target(0, 400))
				.push(Tween.to(sunEntity, EntityTweener.POSITION_XY, 1f)
						.target(400, 800)).repeatYoyo(4, 0.0f).start(manager);*/

	}

	public void draw(Canvas c, float delta) {
		square.draw(c);
		manager.update(0.01f);
		sunEntity.draw(c);
		
		sunEntity.setRotation(sunEntity.getRotation() + delta*0.1f);
	}

}
