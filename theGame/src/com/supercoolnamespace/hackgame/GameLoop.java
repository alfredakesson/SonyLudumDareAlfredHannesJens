package com.supercoolnamespace.hackgame;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import entities.GroundEntity;
import entities.HouseEntity;
import entities.SkyBox;
import entities.SunEntity;

public class GameLoop {
	private static final String TAG = MainActivity.class.getSimpleName();
	private TweenManager manager;
	private SquareEntity square;
	private Point displaySize;
	private SunEntity sunEntity;

	private final float NIGHT_START_ANGLE = 0.5f;
	private final float DAWN_TIME = 0.5f;

	private final int SKY_DAY = Color.rgb(135, 206, 235);
	private final int SKY_NIGHT = Color.rgb(18, 129, 255);

	private GroundEntity groundEntity;

	private ArrayList<SkyBox> skyboxes;

	private ArrayList<HouseEntity> houses;

	private HouseEntity houseEntity;

	public boolean sunUp;

	private TweenManager colorManager;

	public GameLoop(Context context) {

		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();

		displaySize = new Point();
		display.getSize(displaySize);

		Tween.registerAccessor(Entity.class, new EntityTweener());
		// Tween.registerAccessor(SquareEntity.class, new EntityTweener());

		Tween.registerAccessor(SkyBox.class, new OpacityTweener());
		manager = new TweenManager();

		square = new SquareEntity(context, 0, 0);

		float xMove = getMoveLengthX(square, 0.5f);
		float yMove = getMoveLengthY(square, 0.5f);

		Tween.to(square, EntityTweener.POSITION_XY, 4f).target(xMove, yMove)
				.start(manager);

		sunEntity = new SunEntity(displaySize.x / 2, displaySize.y / 2);
		groundEntity = new GroundEntity(displaySize.x / 2, 0, 50, 3000,
				displaySize.y);

		sunUp = true;

		/*
		 * Timeline.createSequence() .push(Tween.to(sunEntity,
		 * EntityTweener.POSITION_XY, 1f) .target(0, 400))
		 * .push(Tween.to(sunEntity, EntityTweener.POSITION_XY, 1f) .target(400,
		 * 800)).repeatYoyo(4, 0.0f).start(manager);
		 */
		skyboxes = new ArrayList<SkyBox>();

		skyboxes.add(new SkyBox(0, 0, displaySize.x / 2, displaySize.y, SKY_DAY));
		skyboxes.add(new SkyBox(displaySize.x / 2, 0, displaySize.x / 2,
				displaySize.y, SKY_DAY));

		houses = new ArrayList<HouseEntity>();

		HouseEntity tempHouse = new HouseEntity(400, 50, 300, 150);

		tempHouse.setRotation(-3);
		houses.add(tempHouse);

		tempHouse = new HouseEntity(100, 50, 300, 150);
		tempHouse.setRotation(4);
		houses.add(tempHouse);

		houseEntity = new entities.HouseEntity(100, 100, 50, 50);

		colorManager = new TweenManager();

	}

	public void draw(Canvas c, float delta) {

		if (!sunUp && Math.sin(sunEntity.rotation + NIGHT_START_ANGLE) > 0) {

			Tween.to(skyboxes.get(1), OpacityTweener.TWEEN_OPACITY, DAWN_TIME)
					.target(SkyBox.OPACITY_DAY).start(colorManager);
			Tween.to(skyboxes.get(0), OpacityTweener.TWEEN_OPACITY, DAWN_TIME)
					.target(SkyBox.OPACITY_NIGHT).start(colorManager);

			sunUp = true;
		}

		if (sunUp && Math.sin(sunEntity.rotation + NIGHT_START_ANGLE) < 0) {
			Tween.to(skyboxes.get(0), OpacityTweener.TWEEN_OPACITY, DAWN_TIME)
					.target(SkyBox.OPACITY_DAY).start(colorManager);
			Tween.to(skyboxes.get(1), OpacityTweener.TWEEN_OPACITY, DAWN_TIME)
					.target(SkyBox.OPACITY_NIGHT).start(colorManager);

			sunUp = false;
		}

		for (SkyBox sb : skyboxes) {
			sb.draw(c);
		}

		houseEntity.setRotation(houseEntity.getRotation() + delta);

		square.draw(c);
		manager.update(delta);
		sunEntity.setRotation(sunEntity.getRotation() + delta);
		manager.update(0.01f);
		sunEntity.draw(c);

		groundEntity.draw(c);
		houseEntity.draw(c);

		for (HouseEntity he : houses) {
			he.draw(c);
		}

		colorManager.update(delta);

	}

	// not working yet!
	public float getMoveLengthX(Entity e, float moveVal) {
		Log.d(TAG,
				"getMoveLen + entityX = " + e.getX() + " entityY = " + e.getY());
		Log.d(TAG, "getMoveLen + dispSize = " + displaySize.x + " "
				+ displaySize.y);
		float normalizedSize = e.getX() / displaySize.x;
		// Log.d(TAG, "" + normalizedSize);
		return normalizedSize * moveVal;
	}

	public float getMoveLengthY(Entity e, float moveVal) {
		float normalizedSize = e.getY() / displaySize.y;
		return normalizedSize * moveVal;
	}

}
