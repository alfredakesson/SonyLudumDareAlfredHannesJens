package com.supercoolnamespace.hackgame;

import java.util.ArrayList;
import java.util.LinkedList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import entities.GroundEntity;
import entities.HouseEntity;
import entities.SkyBox;
import entities.SunEntity;

public class GameLoop {

	private static final String TAG = MainActivity.class.getSimpleName();

	private TweenManager manager;
	private TweenCallback tweenCallback;
	private int nbrOfSquaresSpawned;

	private Point displaySize;

	public boolean sunUp;

	private final float NIGHT_START_ANGLE = 0.5f;
	private final float DAWN_TIME = 0.5f;

	private final int SKY_DAY = Color.rgb(135, 206, 235);
	private final int SKY_NIGHT = Color.rgb(18, 129, 255);

	private SunEntity sunEntity;
	private HouseEntity houseEntity;
	private GroundEntity groundEntity;

	private ArrayList<SkyBox> skyboxes;
	private ArrayList<HouseEntity> houses;

	private Context context;
	
	private LinkedList<SquareEntity> sq = new LinkedList<SquareEntity>();

	private TweenManager colorManager;


	public void removeTopSqure(){
		sq.removeFirst();
	}
	

	public GameLoop(Context context) {

		// Get the screen size of the device
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		displaySize = new Point();
		display.getSize(displaySize);

		Tween.registerAccessor(Entity.class, new EntityTweener());
		// Tween.registerAccessor(SquareEntity.class, new EntityTweener());

		Tween.registerAccessor(SkyBox.class, new OpacityTweener());
		manager = new TweenManager();


		sunEntity = new SunEntity(displaySize.x / 2, displaySize.y / 2);
		groundEntity = new GroundEntity(displaySize.x / 2, 0, 50, 3000,
				displaySize.y);
		sunUp = true;

		// Create the skyboxes
		skyboxes = new ArrayList<SkyBox>();

		skyboxes.add(new SkyBox(0, 0, displaySize.x / 2, displaySize.y, SKY_DAY));

		skyboxes.add(new SkyBox(displaySize.x / 2, 0, displaySize.x / 2,
				displaySize.y, SKY_DAY));

		// Create the houses
		houses = new ArrayList<HouseEntity>();
		HouseEntity tempHouse = new HouseEntity(400, 50, 300, 150);

		tempHouse.setRotation(-3);
		houses.add(tempHouse);

		tempHouse = new HouseEntity(100, 50, 300, 150);
		tempHouse.setRotation(4);
		houses.add(tempHouse);

		
		houseEntity = new entities.HouseEntity(100, 100, 50, 50);

		
		// Create treadmill with squares, add callback function to the tween
		// such that we can spawn other squares
		manager = new TweenManager();
		Tween.registerAccessor(Entity.class, new EntityTweener());

		this.context = context;
		newSqure();
		
		colorManager = new TweenManager();
		
		
	}



	public void newSqure() {
		SquareEntity temp = new SquareEntity(context, 400, 0);
		sq.add(temp);
		Tween.to(temp, EntityTweener.POSITION_XY, 0.5f)
				.target(400,200).repeat(5, 1.0f).start(manager).setCallback(new SquareCallback(temp,this)).setCallbackTriggers(TweenCallback.ANY);
	}

	public void draw(Canvas c, float delta) {


		if (!sunUp && Math.sin(sunEntity.rotation + NIGHT_START_ANGLE) > 0) {

			Tween.to(skyboxes.get(1), OpacityTweener.TWEEN_OPACITY, DAWN_TIME)
					.target(SkyBox.OPACITY_DAY).start(colorManager);
			Tween.to(skyboxes.get(0), OpacityTweener.TWEEN_OPACITY, DAWN_TIME)
					.target(SkyBox.OPACITY_NIGHT).start(colorManager);
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

		sunEntity.setRotation(sunEntity.getRotation() + delta);
		sunEntity.draw(c);

		groundEntity.draw(c);
		houseEntity.draw(c);

		for (HouseEntity he : houses) {
			he.draw(c);
		}
		
		for (SquareEntity sque : sq) {
			sque.draw(c);
			
		}
		


		colorManager.update(delta);
		
		manager.update(delta);

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
